import java.io.FileNotFoundException;
import java.io.IOException;

public class ItemChest implements GeneratedEvent, Nameable{
	private String name;
	private int level; //not sure if we will use this.
	private boolean interacted;
	private static NameGenerator itemChestNames = null;

	public ItemChest(String name, int level){
		this.name = name;
		this.level = level;
		this.interacted = false;
	}
	
	public ItemChest(){
		this.name = null;
		this.level = 0;
		this.interacted = false;
	}
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		ItemChest.itemChestNames = namer.namesListFor(ItemChest.class);
	}
	
	public void setupName(String name){
		if (this.name == null)
			this.name = name;
	}
	
	public void setupLevel(int level){
		if (this.level == 0)
			this.level = level;
	}
	
	public void addItselfRoom(Room room, int potential){
		try{
			room.addGeneratedEvent(ItemChest.class,ItemChest.itemChestNames,potential);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean active(){
		return !this.interacted;
		//TODO check if list is empty and return false
	}
	
	public boolean damage(int damage){
		return false;
	}
	
	public int attack(){
		return 0;
	}
	public boolean dropsItem(int playerLuck){
		int itemRoll = (int)Math.random()*100;
		if(itemRoll <= playerLuck*5){
			return true;
		}
		return false;
	}
	
	public Item pickUpItem(int luck){
		if (interacted == false){
			this.interacted = true;
			return new Item(level,luck); // luck won't be needed since the chest was already found?
		}
		return null;
	}
	
	public String getInteraction(){
		return "You found an "+name+"!";// Player dont know if is a ItemChest or a Trap
	}

	public void interacts(Player player){
		if (interacted == false){
			this.interacted = true;
			player.addToInventory(new Item(level,player.getLuck()));
		}
	}
}
