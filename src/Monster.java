//class Monster implements GeneratedEvent{
class Monster{
	private String name;
	private int level;
	private int health;
	private int str,agi,dex,intl,vit,luck; 

	
	//public Monster(Scenario scene, int level){
	//	this.name = scene.getMonsterName();
	//	this.level = level;
	//	generateStats();
	//}
	public Monster(String name,int level){ //constructor only for test purposes
		this.name = name;
		this. level = level;
		generateStats();
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
	}
	
	public boolean active(){
		if (health > 0){
			return true;
		}
		return false;
	}
	public void damage(int damage){
		health = health - damage;
		if(health < 0){
			health = 0;
		}
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
	
//	public void addItselfRoom(Room room, int potential){
//		room.addEventGenerated(this.getClass(),potential);
//	}
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
