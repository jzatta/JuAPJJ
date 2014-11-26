import java.io.FileNotFoundException;
import java.io.IOException;

class Item implements java.io.Serializable, Nameable{
	private String name;
	private int attack, defense;
	private static NameGenerator itemNames = null;
	private static final factor = 2;
	
	public void updateNames(Namer namer) throws FileNotFoundException, IOException{
		Item.itemNames = namer.namesListFor(Item.class);
	}
	
	public Item(){
	}

	public Item(int plevel, int luck){
		if(itemNames != null) this.name = itemNames.getName();
		attack = (int)(Math.random() * plevel*factor * luck*factor);
		defense = (int)(Math.random() * plevel*factor * luck*factor);
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
	public String itemName(){
		return name;
	}
	public String toString(){
		return itemName();
	}
}
