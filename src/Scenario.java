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
	
	public NameGenerator namesListFor(Class<?> toSearch) throws NameGeneratorFault{
		NameGenerator q = new NameGenerator();
		q.addNoun("bixo");
		q.addNoun("elefante");
		q.addAdjective("de sete pes, de comprimento");
		q.addAdjective("branco");
		return q;
	}
	
	// TODO namesListFor
}
