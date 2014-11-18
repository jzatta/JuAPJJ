class Monster implements GeneratedEvent{
	private String name;
	private int level;
	private int health;
	private int str,agi,dex,intl,vit,luck;
	private int armorLevel, weaponLevel;


	public Monster(String name,int level){ //constructor only for test purposes
		this.name = name;
		this. level = level;
		generateStats();
	}
	
	public Monster(){
		this.name = null;
		this.level = 0;
		generateStats();
	}
	
	public void setupName(String name){
		if (name == null){
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
		str = (int)((Math.random()*100)%(level+10))+1; //somando 1 pra nao dar zero, HUEHUE
		agi = (int)((Math.random()*100)%(level+10))+1;
		dex = (int)((Math.random()*100)%(level+10))+1;
		intl = (int)((Math.random()*100)%(level+10))+1;
		vit = (int)((Math.random()*100)%(level+10))+1;
		luck = (int)((Math.random()*100)%(level+10))+1;
		armorLevel = (int)(Math.random()*level-1);
		weaponLevel = (int)(Math.random()*level-1);
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
	
	
	public boolean dropsItem(int playerLuck){
		int itemRoll = (int)Math.random()*100;
		if(itemRoll <= playerLuck*5){
			return true;
		}
		return false;
	}
	
	public Item pickUpItem(int luck){
		//return item generated with base on level and Math.random();
		return null;
	}
	
	public String getInteraction(){
		return "You face " + this.name + ". It appears to be a level " + level + " monster.";
	}
	
	public static void addItselfRoom(Room room, Scenario scene, int potential){
		Monster me = new Monster("",1);
		room.addGeneratedEvent(me.getClass(),scene.namesListFor(me),potential);
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
