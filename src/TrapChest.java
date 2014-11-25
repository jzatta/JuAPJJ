import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

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
		TrapChest.trapNames = namer.namesListFor(ItemChest.class);
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
		return "Você encontrou um "+name+"!";// Player dont know if is a ItemChest or a Trap
	}
	
	public void interacts(Player player){
		Master.ioManager.showMessage(this.getInteraction());
		int pAction = this.getAction(player);
		if (interacted == false && (pAction == 1)){
			double chance = ((level * 0.75) + 4) * (Math.random()*1.75); // rever formula
			if (chance > player.chanceToEscape()){
				player.damage((int)(Math.random() * (15 + (level * 0.6))));
				Master.ioManager.showMessage("Xablaw! Isso foi uma armadilha " + this.name + ". Teu Hp é "+player.getHP());
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
				Master.ioManager.showMessage("Xablaw! Isso foi uma armadilha " + this.name + ". Reuiá! Você escapou");
				this.interacted = true;
			}
		}
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
