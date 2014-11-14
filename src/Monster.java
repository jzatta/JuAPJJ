class Monster implements GeneratedEvent{
	private String name;
	private int level;
	private int health;
	private int armorLevel;
	private int weaponLevel;
	
	public Monster(Scenario scene, int level){
		this.name = scene.getMonsterName();
		this.level = level;
		
		// configure other attributes based on level and Math.random
	}
	
	public boolean active(){
		if (health > 0){
			return true;
		}
		return false;
	}
	public boolean damage(int damage){
		health = health - damage;
		if(health < 0){
			health = 0;
		}
	}
	
	public int attack(){
		//algorithm to reduce player health
	}
	public boolean dropsItem(int luck){
		// could find an item, something like: if you dosen't pickUp an item yet
	}
	public Item pickUpItem(int luck){
		// return item generated with base on level and Math.random
	}
	
	public String getInteraction(){
		return "In your front are a " + this.name + ". Him appear to be a " + level + " monster.";
	}
}
