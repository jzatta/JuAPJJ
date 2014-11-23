import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

class Room implements Nameable{
	private String localName;
	private int difficulty;
	private static List<Class<?>> classesList;
	private static List<Integer> potentialList;
	private static List<NameGenerator> namesList;
	private static final int variance = 7;
	private static NameGenerator roomNames = null;
	
	
	public Room(Namer namer, int level) throws FileNotFoundException, IOException{
		namer.addNameable(this);
		this.localName = roomNames.getName();
		this.difficulty = level;
		classesList = new ArrayList<Class<?>>();
		potentialList = new ArrayList<Integer>();
		namesList = new ArrayList<NameGenerator>();
	}
	
	public String roomName(){
		return this.localName;
	}
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		Room.roomNames = namer.namesListFor(Room.class);
	}
	
	public void addGeneratedEvent(Class<?> classOf, NameGenerator names, int potential){
		Room.classesList.add(classOf);
		Room.potentialList.add(potential);
		Room.namesList.add(names);
	}
	
	GeneratedEvent getEvent(){
		double mostChance = 0;
		int arrayIndex = 0;
		int makingDifficulty = (int)(Math.random() *Room.variance) - ((Room.variance + 1) / 2) + difficulty;//variavel estatica
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
			event.setupName(namesList.get(arrayIndex).getName());
			event.setupLevel(makingDifficulty);
			return event;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
