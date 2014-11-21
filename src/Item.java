class Item{
	private String name;
	private static NameGenerator itemNames;
	public Item(int plevel, int luck){}
	
	int reduceDamage(){
		return 0;
	}
		// if equipped, can reduce damage suffered by player
	int increaseDamage(){
		return 0;
	}
		// if equipped, can increase damage applied by player
	double weight(){
		return 0.0;
	}
}
