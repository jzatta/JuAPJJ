import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.*;

class Scenario implements Namer{
	private String templatesDir;
	private List<Class<Nameable>> nameablesClasses;
	
	
	public Scenario(){ //constructor for test Purposes
		this.templatesDir = ".";
		nameablesClasses = new ArrayList<Class<Nameable>>();
	}

	public boolean addNameable(Nameable nameable) throws FileNotFoundException, IOException
{
		boolean added = false;
		if(!nameablesClasses.contains(nameable.getClass())){
			added = nameablesClasses.add((Class<Nameable>)nameable.getClass());
			nameable.updateNames(this);
		}
		return added;
	}

	public Scenario(String templatesDir) throws FileNotFoundException, IOException{
		this.templatesDir = templatesDir;
		nameablesClasses = new ArrayList<Class<Nameable>>();
		// Load templates from file
	}
	
	public void reloadTemplates(String templatesDir){
		// Load a new template
	}
	
	public Room generateRoom(int level) throws FileNotFoundException, IOException{
		int makingDifficulty = (int)(Math.random() * 5) - 2 + level;
		return new Room(this,makingDifficulty);
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
