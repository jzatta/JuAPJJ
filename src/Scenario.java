import java.io.File;

class Scenario{
	NameGenerator roomNames;
	
	
	public Scenario(String templatesDir){
		// Load templates from file
	}
	
	public void reloadTemplates(String templatesDir){
		// Load a new template
	}
	
	public Room getRoom(int level){
		int makingDifficulty = (int)(Math.random() * 5) - 2 + level;
		return new Room(getRoomName(),makingDifficulty);
	}
	
	public String getRoomName(){
		return this.roomNames.getName();
	}
	
	public NameGenerator namesListFor(GeneratedEvent toSearch) throws NameGeneratorFault{
		
	}
	
	// TODO namesListFor
}
