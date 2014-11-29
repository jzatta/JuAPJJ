import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class GenericEvent implements GeneratedEvent, Nameable{
	private String name;
	private int level;
	private static NameGenerator names = null;

	public GenericEvent(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	public GenericEvent(){
		this.name = null;
		this.level = 0;
	}

	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		this.names = namer.namesListFor(this.getClass());
	}
	
	public void setupName(String name){
		if (this.name == null)
			this.name = name;
	}
	
	public void setupLevel(int level){
		this.level = level;
	}
	
	protected void setupNameGenerator(NameGenerator names){
		this.names = names;
	}
	
	public void addItselfRoom(Room room, int potential){
		try{
			room.addGeneratedEvent(this.getClass(),this.names,potential);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getLevel(){
		return level;
	}
	
	public abstract boolean active();
	
	public abstract boolean damage(int damage);
	
	public abstract int attack();
	
	public abstract boolean dropsItem(int luck);
	
	public abstract String getInteraction();
	
	public abstract void interacts(Player player);
}