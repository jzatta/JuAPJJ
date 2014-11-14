class Monster implements GeneratedEvent{
	private String name;
	private int level;
	private int health;
	private int armorLevel;
	private int 
	
	Public Monster(Scenario scene, int level){
		this.name = scene.getMonsterName();
		this.level = level;
	}
	
	public boolean actived(){
		if (health > 0)
			return true;
		return false;
	}
	public int attack(int damage){
		//algorithm to reduce monster health
	}
	public int counterAttack();
	public boolean hasItem(int luck);
	public Item pickUpItem(int luck);
}