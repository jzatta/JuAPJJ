class Room{
	private String localName;
	private int difficulty;
	private static final int variance = 7;
	private static final int potentialMonster = 16;
	private static final int potentialTrap = 8;
	private static final int potentialChest = 4;
	
	public Room(String roomName, int level){
		this.localName = roomName;
		this.difficulty = level;
	}
	
	String roomName(){
		return this.localName;
	}
	
	GeneratedEvent getEvent(Scenario scene){
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
		if (makingDifficulty < 0){
			makingDifficulty = 0;
		}
		switch (makingtype){
			case 0:
				return new Monster(scene,makingDifficulty);
				case 1:
				return new Trap(scene,makingDifficulty);
			case 2:
				return new Chest(scene,makingDifficulty);
		}
	}
 } //callback
