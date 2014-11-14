class Monster implements GeneratedEvent{
	private String name;
	private int level;
	private int health;
	private int armorLevel;
	private int weaponLevel;
	
	Public Monster(Scenario scene, int level){
		this.name = scene.getMonsterName();
		this.level = level;
		// configure other attributes based on level and Math.random
	}
	
	public boolean actived(){
		if (health > 0)
			return true;
		return false;
	}
	public boolean attack(int damage){
		//algorithm to reduce monster health
	}
	
	public int counterAttack(){
		//algorithm to reduce player health
	}
	public boolean hasItem(int luck){
		// could find an item, something like: if you dosen't pickUp an item yet
	}
	public Item pickUpItem(int luck){
		// return item generated with base on level and Math.random
	}
}