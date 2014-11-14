class Room{
	private String localName;
	private int difficulty;
	private static final int variance = 7;
	private static final int potentialMonster = 1;
	private static final int potentialTrap = 1;
	private static final int potentialChest = 1;
	
	Public Room(String roomName, int level){
		this.localName = roomName;
		this.difficulty = level;
	}
	
	String getName(){
		return this.localName;
	}
	
	GeneratedEvent getEvent(){
		int makingtype;
		double chanceMonster = Math.random() * this.potentialMonster;
		double chanceTrap = Math.random() * this.potentialTrap;
		double chanceChest = Math.random() * this.potentialChest;
		if (chanceMonster > chanceTrap){  //check if logic are correct
			if (chanceMonster > chanceChest) makingtype = 0;
			else makingtype = 2;
		} else {
			if (chanceTrap > chanceChest) makingtype = 1;
			else makingtype = 2;
		}
		int makingDifficulty = (int)(Math.random() * this.variance) - ((this.variance + 1) / 2) + this.difficulty;
		switch (type){
			case 0:
				return new Monster(makingDifficulty);
			case 1:
				return new Trap(makingDifficulty);
			case 2:
				return new Chest(makingDifficulty);
		}
	}
}