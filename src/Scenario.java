import java.io.File;//a gente ainda precisa disso? 

class Scenario{
	NameGenerator roomNames;
	
	public Scenario(NameGenerator n){ //constructor for test Purposes
		roomNames = n;
	}	
	public Scenario(String templatesDir){
		// Load templates from file
	}
	
	public void reloadTemplates(String templatesDir){
		// Load a new template
	}
	
	public Room getRoom(int level){
		int makingDifficulty = (int)(Math.random() * 5) - 2 + level;
		return new Room(this,makingDifficulty);
	}
	
	public String getRoomName(){
		return this.roomNames.getName();
	}
	
	public NameGenerator namesListFor(GeneratedEvent toSearch) throws NameGeneratorFault{
		return null;
	}
	
	// TODO namesListFor
}
