import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class ItemChest extends GenericEvent{
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
		return "Você encontrou um "+name+"!";// Player dont know if is a ItemChest or a Trap
	}

	public void interacts(Player player){
		Master.ioManager.showMessage(this.getInteraction());
		int pAction = this.getAction(player);
		if (interacted == false && (pAction == 1)){
			this.interacted = true;
			Item item = new Item(level,player.getLuck());
			player.addToInventory(item);
			Master.ioManager.showMessage("Voce achou "+item);
		}
		Master.ioManager.waitInteraction();
		Master.ioManager.clearScreen();
	}
	
	private int getAction(Player player){
		int action= 1;
		while(true){
			Master.ioManager.showMessage("O que "+player.getName()+" fará?");
			Master.ioManager.showMessage("=-=-=-=-=-=-=-");
			Master.ioManager.showMessage("1.Pegar o que tem dentro\n2.Deixar quieto\n");
			Master.ioManager.showMessage("=-=-=-=-=-=-=-");	
			try{
				action = Master.ioManager.getCommand();
			
				if(action < 1 || action > 2){
					Master.ioManager.showMessage("Opção inválida");
				}
				else{
					break;
				}
				
			}catch(InputMismatchException e){
				Master.ioManager.showMessage("Eu pedi um inteiro mano");
			}
		}
		return action;
	}
}
