import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.*;

class Scenario implements Namer{
	NameGenerator roomNames;
	private String templatesDir;
	private List<Nameable> nameables;
	
	
	public Scenario(NameGenerator n){ //constructor for test Purposes
		roomNames = n;
		this.templatesDir = ".";
		nameables = new ArrayList<Nameable>();
	}

	public boolean addNameable(Nameable nameable) throws FileNotFoundException, IOException
{
		boolean added = false;
		if(!nameables.contains(nameable)) added = nameables.add(nameable);
		updateNameables();
		return added;
	}
	public void updateNameables() throws FileNotFoundException, IOException{
		for(Nameable nameable : nameables)
			nameable.updateNames(this);
	}
	public Scenario(String templatesDir) throws FileNotFoundException, IOException{
		this.templatesDir = templatesDir;
		this.roomNames = namesListFor(Room.class);
		nameables = new ArrayList<Nameable>();
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

	public History getHistory() throws FileNotFoundException, IOException{
		File nameFile = new File(this.templatesDir+"/"+"History.json");
			int charReaded;
		StringBuilder jsonStr = new StringBuilder();
		FileReader reader = new FileReader(nameFile);
		while( (charReaded = reader.read()) > 0) jsonStr.append((char)charReaded);
		Gson jsonConverter = new Gson();
		return jsonConverter.fromJson(jsonStr.toString(),History.class);
	}
	
	// TODO namesListFor
}
