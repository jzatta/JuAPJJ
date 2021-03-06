import java.util.*;

class Player implements java.io.Serializable{
	private String name;
	private int str,agi,dex,intl,vit,luck; //stats in combat
	private int baseStr,baseAgi,baseDex,baseIntl,baseVit,baseLuck;//base stats
	private int baseHP,baseSP; //calculados a partir de vit e intl, respectivamente
	private int currentHP,currentSP; //HP e SP durante o combate
	private int level; //vamos fazer de 1 a 99? 
	private int exp; //experiência atual
	private int nextLevel; //exp necessaria pra subir para o proximo level
	private List<Skill> skills;
	private List<Item> inventory;
//	private Item[] equipedItems;
	private int itemCounter;//soma dos pesos dos itens no inventario
	

	public Player(String name){
		this.name = name;
		this.level = 1;
		skills = new ArrayList<Skill>();
		inventory = new ArrayList<Item>();
//		equipedItems = new Item[4]; //Weapon, armor, shield, boots
		itemCounter = 0;
		baseStr = 5;
		baseAgi = 5;
		baseDex = 5;
		baseIntl = 5;
		baseVit = 10;
		baseLuck = 5;
		calculateHpSp(); //funcao que calcula hp e sp maximos;
		currentHP = baseHP;
		currentSP = baseSP;
	   	this.str = baseStr;
		this.agi = baseAgi;
		this.dex = baseDex;
		this.intl = baseIntl;
		this.vit = baseVit;
		this.luck = baseLuck;
		nextLevel = 50;
		addInitialSKills();
	}
	public void calculateHpSp(){
		this.baseHP = 50+ 10* baseVit;
		this.baseSP = (int)(10+0.25*intl);
	}
	public boolean isAlive(){
		if(currentHP > 0){
			return true;
		}
		return false;
	}
    public void addInitialSKills(){
        HealSkill initialHealing = new HealSkill("Cura I",15);
        BuffSkill initialStrBuff = new BuffSkill("STR","Aumentar STR I",3);
        PhysicalDamageSkill initialPhysicalDamage = new PhysicalDamageSkill("Socão cabuloso da perdição",10);
        MagicDamageSkill initialMagicDamage = new MagicDamageSkill("Macumba cabulosa",8);
        skills.add(initialHealing);
        skills.add(initialStrBuff);
        skills.add(initialPhysicalDamage);
        skills.add(initialMagicDamage);
    } 
	
	public int getStr(){ return str; }
	public int getAgi(){ return agi;}
	public int getDex(){ return dex; }
	public int getIntl(){ return intl; }
	public int getVit(){ return vit; }
	public int getLuck(){ return luck; }//SHE'S UP ALL NIGHT TO getLucky
	public int getLevel(){ return level; }
	public String getName(){ return name; }
	public int getHP(){ return currentHP; }
	
	public List<Skill> listSkills(){
		return skills;
	}
	public List<Item> listItems(){
		return inventory;
	}

	public void levelUp(){
		level++;
		increaseStats();
		calculateHpSp();
        levelUpSkills();
		exp = 0;
		nextLevel*=(level)*(level)*50;
		fillHP();
	}
    public void levelUpSkills(){
        for(Skill skill:skills){
            skill.levelUp();
        }
    }
	private void fillHP(){
		currentHP = baseHP;
	}
	public void damage(int d){
		currentHP -= d;
		if(currentHP < 0){
			currentHP = 0;
		}
	}
	public void heal(int h){
		currentHP += h;
		if(currentHP > baseHP){
			currentHP = baseHP;
		}
	}
	public void resetStats(){ //remove  buffs or debuffs after combat
		str = baseStr;
		agi = baseAgi;
		dex = baseDex;
		intl = baseIntl;
		vit = baseVit;
		luck = baseLuck;
	}
	public void increaseStats(Stats toIncrease){
		switch(toIncrease){
			case STR:
				baseStr+=3;
				break;
			case AGI:
				baseAgi+=3;
				break;
			case DEX:
				baseDex+=3;
				break;
			case INTL:
				baseIntl+=3;
				break;
			case VIT:
				baseVit+=3;
				break;
			case LUCK:
				baseLuck+=3;
				break;
			default:
				break;
		}
	}
	public void increaseStats(){
		Stats toIncrease = null;
		String statToIncrease = Master.ioManager.getString("Você upou! Qual stat aumentar(STR,AGI,DEX,INTL,VIT,LUCK)?");
		for(Stats stat:Stats.values()){
			if(statToIncrease.equalsIgnoreCase(stat.name())){
				toIncrease = stat;
			}
		}
		increaseStats(toIncrease);
	}
	public void buffStr(int factor){
		str+= factor;
	}
	public void buffAgi(int factor){
		agi+= factor;
	}
	public void buffDex(int factor){
		dex+= factor;
	}
	public void buffIntl(int factor){
		intl+= factor;
	}
	public void buffVit(int factor){
		vit+= factor;
	}
	public void buffLuck(int factor){
		luck+=factor;
	}
	public void addSkill(Skill s){
		skills.add(s);
	}
	public void removeSkill(Skill s){
		skills.remove(s);
	}
	public void addToInventory(Item i){
		if(itemCounter < 5){ 
			inventory.add(i);
            itemCounter++;
		}
		else{
			itemCounter--;
			Master.ioManager.showMessage("Pena que seu inventário estava cheio :/");
		}
	}
	public void removeFromInventory(Item i){
		inventory.remove(i);
	    itemCounter--;
	}/*
	public void equipWeapon(Item w){ //weapons go to equipedItems[0]
		if(!inventory.contains(w)){
			return; //if the item is not on the inventory, gtfo
		}
		removeFromInventory(w); //we take the weapon from the inventory to free space
		//we check if something is already equiped
		if(equipedItems[0] != null){
			inventory.add(equipedItems[0]);//and put it back on the inventory			
			baseStr -= equipedItems[0].increaseDamage(); //remove the damage bonus			
		}
		baseStr += w.increaseDamage();
		equipedItems[0] = w; // and finally equip the weapon. Should work.
	}*/
	
	public double chanceToEscape(){
		double formula = agi * 0.35 + dex * 0.35 + intl * 0.2 + luck * 0.1;
		return formula;
	}
	public void gainExp(int exp){
		this.exp+= exp;
		if(this.exp >= nextLevel){
			levelUp();
		}
	}

}
