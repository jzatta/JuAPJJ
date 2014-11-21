import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.Arrays;

class Scenario{
	NameGenerator roomNames;
	private String templatesDir;
	
	
	public Scenario(NameGenerator n){ //constructor for test Purposes
		roomNames = n;
		this.templatesDir = ".";
	}

	public Scenario(String templatesDir) throws FileNotFoundException, IOException{
		this.templatesDir = templatesDir;
		this.roomNames = namesListFor(Room.class);
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
	
	public NameGenerator namesListFor(Class<?> toSearch) throws FileNotFoundException, IOException{
		File nameFile = new File(this.templatesDir+"/"+toSearch.getName()+"Names.json");
		int charReaded;
		StringBuilder jsonStr = new StringBuilder();
		FileReader reader = new FileReader(nameFile);
		while( (charReaded = reader.read()) > 0) jsonStr.append((char)charReaded);
		Gson jsonConverter = new Gson();
		return jsonConverter.fromJson(jsonStr.toString(),NameGenerator.class);
	}
	
	// TODO namesListFor
}
