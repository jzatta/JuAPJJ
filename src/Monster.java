//class Monster implements GeneratedEvent{
class Monster{
	private String name;
	private int level;
	private int health;
	private int str,agi,dex,intl,vit,luck;
	private int armorLevel, weaponLevel;

	
	public Monster(Scenario scene, int level){
		this.name = scene.getMonsterName();
		this.level = level;
		generateStats();
	}
	
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
	
	public void setuptScenario(Scenario scene){
		if (name == null){
			scene.getMonsterName();
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
		if(health <= 0){
			health = 0;
			return false;
		}
		return true;
	}
	/*
	public int attack(){
		//damage is being calculated at the Combat class
		//algorithm to reduce player health
	}*/
	
	
	public boolean dropsItem(int playerLuck){
		int itemRoll = (int)Math.random()*100;
		if(itemRoll <= playerLuck*5){
			return true;
		}
		return false;
	}
	//public Item pickUpItem(int luck){
		// return item generated with base on level and Math.random
	//}
	
	public String getInteraction(){
		return "You face " + this.name + ". It appears to be a " + level + " monster.";
	}
	
	public static void addItselfRoom(Room room, int potential){
		room.addEventGenerated(new Monster("",1).getClass(),potential);
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
}
