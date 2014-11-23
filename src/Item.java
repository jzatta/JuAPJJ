import java.io.FileNotFoundException;
import java.io.IOException;

class Item implements java.io.Serializable{
	private String name;
	private int attack, defense;
	private static NameGenerator itemNames;
	
	
	public void configureItself(Scenario scene) throws FileNotFoundException, IOException{
		Item.itemNames = scene.namesListFor(Item.class);
	}
	
	public Item(int plevel, int luck){
		if(itemNames != null) this.name = itemNames.getName();
		attack = (int)(Math.random() * plevel*0.75 * luck*0.75);
		defense = (int)(Math.random() * plevel*0.75 * luck*0.75);
	}
	
	public int reduceDamage(){
		return defense;
	}
	
	public int increaseDamage(){
		return attack;
	}
	
	public double weight(){
		int weight =(int) Math.sqrt(attack*defense);
		return weight;
	}
}
