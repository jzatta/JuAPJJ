//class Monster implements GeneratedEvent, Interable{
import java.io.FileNotFoundException;
import java.io.IOException;

class Monster extends GenericEvent{
	private String name;
	private int level;
	private int health;
	private int str,agi,dex,intl,vit,luck;
	private int armorLevel, weaponLevel;
	private int expToGive;
	private boolean itemPuckUp;
	private static NameGenerator monsterNames = null;


	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		Monster.monsterNames = namer.namesListFor(Monster.class);
	}

	public Monster(String name,int level){ //constructor only for test purposes
		this.name = name;
		this. level = level;
		this.itemPuckUp = false;
		generateStats();
	}
	
	public Monster(){
		this.name = null;
		this.level = 0;
		this.itemPuckUp = false;
		generateStats();
	}
	
	public void setupName(String name){
		if (this.name == null){
			this.name = name;
		}
	}
	
	public void setupLevel(int level){
		if (this.level == 0){
			this.level = level;
			generateStats();
		}
	}
	
	public void generateStats(){
		while(health == 0){ //essa formula corre o risco de dar 0, nao queremos um bicho com 0 de hp
			health = (int)((Math.random()*100)%10*(level+10));
		}
		str = (int)((Math.random()*100)%(level+7))+1; //somando 1 pra nao dar zero, HUEHUE
		agi = (int)((Math.random()*100)%(level+7))+1;
		dex = (int)((Math.random()*100)%(level+7))+1;
		intl = (int)((Math.random()*100)%(level+7))+1;
		vit = (int)((Math.random()*100)%(level+7))+1;
		luck = (int)((Math.random()*100)%(level+7))+1;
		armorLevel = (int)(Math.random()*level-1);
		weaponLevel = (int)(Math.random()*level-1);
		expToGive = 5*level*50;
	}
	
	public boolean active(){
		if (health > 0){
			return true;
		}
		return false;
	}
	public boolean damage(int damage){
		if (damage > armorLevel) damage -= armorLevel;
		else damage = 0;
		health = health - damage;
		if(health < 0){
			health = 0;
			return false;
		}
		return true;
	}
	public void damageIgnoreArmor(int damage){
		health -= damage;
		if(health < 0){
			health = 0;
		}
	}
	public int attack(){
// 		damage is being calculated at the Combat class
// 		algorithm to reduce player health
		return 0;
	}
	public int exp(){
		return expToGive;
	}	
	
	public boolean dropsItem(int playerLuck){
		int itemRoll = (int)Math.random()*100;
		if(itemRoll <= playerLuck*5 && !this.itemPuckUp){
			return true;
		}
		return false;
	}
	
	public String getInteraction(){
		return "Você encontrou um " + this.name + ". Trata-se de um monstro nivel " + level + ".";
	}
	
	public void addItselfRoom(Room room, int potential){
		try{
			room.addGeneratedEvent(Monster.class,Monster.monsterNames,potential);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void interacts(Player player){
		if (this.active()){
			Combat c = new Combat(player,this);
			c.fight();
		}
		else if (!this.itemPuckUp){
			player.addToInventory(new Item(level,player.getLuck()));
		}
	}


	public int getLevel() {
		return level;
	}
	public int getStr() {
		return str;
	}
	public int getVit(){
		return vit;
	}
	public int getHP(){
		return health;
	}
	public String getName(){
		return name;
	}
	public int getAgi(){
		return agi;
	}
	public int getIntl(){
		return intl;
	}
	
	public String dataDebug(){
		//just for tests
		return "Name: " + name +"\nLevel: "+ level +"\nHealth: "+ health +"\nstr: "+ str + "\nagi: "+agi + "\ndex: "+dex + "\nintl: "+intl + "\nvit: "+vit + "\nluck: "+luck + "\narmor: "+armorLevel + "\nweapon: "+weaponLevel+"\n"+getInteraction();
	}

}
