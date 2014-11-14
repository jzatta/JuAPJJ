import java.util.HashMap;

class Room{
	private String localName;
	private int difficulty;
	private List<Class<GeneratedEvent>> classesList;
	private List<Integer> potentialList;
	private static final int variance = 7;
	
	public Room(String roomName, int level){
		this.localName = roomName;
		this.difficulty = level;
		classesList = new ArrayList<Class<GeneratedEvent>>();
		potentialList = new ArrayList<Integer>();
	}
	
	String roomName(){
		return this.localName;
	}
	
	public void addEventGenerated(Class<GeneratedEvent> classOf, int potential){
		classesList.add(classOf);
		potentialList.add(potencial);
	}
	
	GeneratedEvent getEvent(Scenario scene){
<<<<<<< HEAD
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
=======
		double mostChance = 0;
		int arrayIndex = 0;
		for(int index = 0; index < potentialList.size(); index++){
			double chance = potentialList.get(index) * Math.random();
			if (chance > mostChance){
				mostChance = chance;
				arrayIndex = index;
			}
>>>>>>> 35cc7fccef16d72122bb3812d689efd24b5fbeb2
		}
		return classesList.get(arrayIndex).newInstance();
	}
 } //callback
