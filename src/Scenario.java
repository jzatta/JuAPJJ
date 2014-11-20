import java.io.File;
import java.io.FileReader;
import com.google.gson.Gson;
import java.util.Arrays;

class Scenario{
	NameGenerator roomNames;
	private String templatesDir;
	
	
	public Scenario(NameGenerator n){ //constructor for test Purposes
		roomNames = n;
	}	

	public Scenario(String templatesDir){
		this.templatesDir = templatesDir;
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
		File nameFile = new File(this.templatesDir+"/"+toSearch.getName()+"Names.json");
		int charReaded;
		StringBuilder jsonStr = new StringBuilder();
		try{
			FileReader reader = new FileReader(nameFile);
			while( (charReaded = reader.read()) > 0){
				jsonStr.append((char)charReaded);
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		Gson jsonConverter = new Gson();
		return jsonConverter.fromJson(jsonStr.toString(),NameGenerator.class);
	}
	
	// TODO namesListFor
}
