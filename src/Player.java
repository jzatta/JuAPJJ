import java.util.*;

class Player{
	private long goldCoins;
	private String name;
	private int str,agi,dex,intl,vit,luck; //stats in combat
	private int baseStr,baseAgi,baseDex,baseIntl,baseVit,baseLuck;//base stats
	private int baseHP,baseSP; //calculados a partir de vit e intl, respectivamente
	private int currentHP,currentSP; //HP e SP durante o combate
	private int level; //vamos fazer de 1 a 99? 
	private int exp; //experiência atual
	private int nextLevel; //exp necessaria pra subir para o proximo level
	private List<Skill> skills;

	public Player(String name){
		this.name = name;
		this.level = 1;
		this.goldCoins = 0L;
		skills = new ArrayList<Skill>();
		baseStr = 5;
		baseAgi = 5;
		baseDex = 5;
		baseIntl = 5;
		baseVit = 10;
		baseLuck = 5;
		calculateHpSp(); //funcao que calcula hp e sp maximos;
		currentHP = baseHP;
		currentSP = baseSP;
		str = baseStr;
		agi = baseAgi;
		dex = baseDex;
		intl = baseIntl;
		vit = baseVit;
		luck = baseLuck;
	}
	public void calculateHpSp(){
		this.baseHP = 50+10*vit;
		this.baseSP = (int)(10+0.25*intl);
	}
	public boolean isAlive(){
		if(currentHP > 0){
			return true;
		}
		return false;
	} 
	public void setStr(int str){ this.str = str; }
	public void setAgi(int agi){ this.agi = agi; }
	public void setDex(int dex){ this.dex = dex; }
	public void setIntl(int intl){ this.intl = intl; }
	public void setVit(int vit){ this.vit = vit; }
	public void setLuck(int luck){ this.luck = luck; }
	
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

	public void levelUp(){
		level++;
		calculateHpSp();
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
}
