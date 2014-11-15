import java.util.*;

class Room{
	private String localName;
	private int difficulty;
	private List<Class<?>> classesList;
	private List<Integer> potentialList;
	private static final int variance = 7;
	
	public Room(String roomName, int level){
		this.localName = roomName;
		this.difficulty = level;
		classesList = new ArrayList<Class<?>>();
		potentialList = new ArrayList<Integer>();
	}
	
	String roomName(){
		return this.localName;
	}
	
	public void addGeneratedEvent(Class<?> classOf, int potential){
		classesList.add(classOf);
		potentialList.add(potential);
	}
	
	GeneratedEvent getEvent(Scenario scene){
		double mostChance = 0;
		int arrayIndex = 0;
		int makingDifficulty = (int)(Math.random() * this.variance) - ((this.variance + 1) / 2) + this.difficulty;
		if (makingDifficulty < 1){
			makingDifficulty = 1;
		}

		for(int index = 0; index < potentialList.size(); index++){
			double chance = potentialList.get(index) * Math.random();
			if (chance > mostChance){
				mostChance = chance;
				arrayIndex = index;
			}
		}
		try{
			GeneratedEvent event = (GeneratedEvent)classesList.get(arrayIndex).newInstance();
			//event.setuptScenario(scene); scenario not full implemented yet
			event.setupLevel(makingDifficulty);
			return event;
		}catch(Exception e){
			System.out.println("Exception: " + e);
			return null;
		}
	}
}
