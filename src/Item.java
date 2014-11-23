class Item{
	private String name;
	private int attack, defense;
	private static NameGenerator itemNames;
	
	
	public void configureItself(Scenario scene) throws FileNotFoundException, IOException{
		this.skillNames = scene.namesListFor(Item.class);
	}
	
	public Item(int plevel, int luck){
		if(skillNames != null) this.name = skillNames.getName();
		attack = Math.random() * level*0.75 * luck*0.75;
		defense = Math.random() * level*0.75 * luck*0.75;
	}
	
	public int reduceDamage(){
		return defense;
	}
	
	public int increaseDamage(){
		return attack;
	}
	
	public double weight(){
		// Not implemented yet
		return 0.0;
	}
}
