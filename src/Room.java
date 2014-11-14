class Room{
	private String localName;
	private int difficulty;
	private static final int variance = 7;
	
	Public Room(String roomName, int level){
		this.localName = roomName;
		this.difficulty = level;
	}
	
	String getName(){
		return this.localName;
	}
	
	GeneratedEvent getEvent(){
		int makingtype = (int)(Math.random() * 3);
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