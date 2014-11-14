import java.io.File;

class Scenario{
	NameGenerator monsterNames;
	NameGenerator itemNames;
	NameGenerator roomNames;
	
	public Scenario(File templates){
		// Load templates from file
	}
	
	public void reloadTemplates(File templates){
		// Load a new template
	}
	
	public Room getRoom(int level){
		int makingDifficulty = (int)(Math.random() * 5) - 2 + level;
		return new Room(getRoomName(),makingDifficulty);
	}
	
	public String getRoomName(){
		return this.roomNames.getName();
	}
	
	public String getMonsterName(){
		// generate name based on templates from file
	}
	
	// TODO methods and attributes to others types of names
}
