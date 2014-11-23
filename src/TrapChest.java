import java.io.FileNotFoundException;
import java.io.IOException;

public class TrapChest implements GeneratedEvent, Nameable{
	private String name;
	private int level; //not sure if we will use this.
	private boolean interacted;
	private static NameGenerator trapNames = null;

	public TrapChest(String name, int level){
		this.name = name;
		this.level = level;
		this.interacted = false;
	}
	
	public TrapChest(){
		this.name = null;
		this.level = 0;
		this.interacted = false;
	}

	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		TrapChest.trapNames = namer.namesListFor(TrapChest.class);
	}
	
	public boolean active(){
		return !this.interacted;
		//TODO check if list is empty and return false
	}
	
	public void setupName(String name){
		if (this.name == null)
			this.name = name;
	}
	
	public void setupLevel(int level){
		this.level = level;
	}
	public void setupNamer(Namer namer) throws FileNotFoundException, IOException{
		namer.addNameable(this);
	}
	
	public void addItselfRoom(Room room, int potential){
		try{
			room.addGeneratedEvent(TrapChest.class,TrapChest.trapNames,potential); // Pick same names from ItemChest
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean damage(int damage){
		return false;
	}
	
	public int attack(){
		return 0;
	}
	
	public boolean dropsItem(int luck){
		return false;
	}
	
	public String getInteraction(){
		return "You found an "+name+"!";// Player dont know if is a ItemChest or a Trap
	}
	
	public void interacts(Player player){
		if (interacted == false){
			double chance = ((level * 0.75) + 4) * (Math.random()*1.75); // rever formula
			if (chance > player.chanceToEscape()){
				player.damage((int)(Math.random() * (15 + (level * 0.6))));
				Master.ioManager.showMessage("It was a trap " + this.name + ". Your Hp is "+player.getHP());
				this.interacted = true;
//Formula: Math.random() * (150 + (level * 0.2 * 3 * 10) * 0.1)
//Math.random()[random] * 
//(150[start hp player] + 
//	(level * 0.2[tax of vit points used per levelUp] *
//	3[points increased in vit points when levelUp] *
//	10[multiply factor of vit points to hp])
//) *
//0.1[10% of player hp]
			} else{
				Master.ioManager.showMessage("It was a trap. You escaped!");
				this.interacted = true;
			}
		}
	}
}
