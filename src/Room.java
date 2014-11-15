import java.util.*;

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
		double mostChance = 0;
		int arrayIndex = 0;
		for(int index = 0; index < potentialList.size(); index++){
			double chance = potentialList.get(index) * Math.random();
			if (chance > mostChance){
				mostChance = chance;
				arrayIndex = index;
			}
		}
		GeneratedEvent event = classesList.get(arrayIndex).newInstance();
		void setuptScenario(scene);
		void setupLevel(makingDifficulty);
		return event;
	}
}
