public class ItemChest implements GeneratedEvent{	
	Scenario scene;
	Item item;
	int level; //not sure if we will use this.

	public ItemChest(Scenario scene, int level){
		this.scene = scene;
		this.level = level;
	}
	public boolean active(){
		return true;
		//TODO check if list is empty and return false
	}
	public boolean damage(int damage){
		return false;
	}
	public int attack(){
		return 0;
	}
	public boolean dropsItem(int luck){
		return true;
	}
	public Item pickUpItem(int luck){
		return item; // luck won't be needed since the chest was already found?
	}
	public String getInteraction(){
		return "You found an item chest! It contains one "+item.itemType();
	}
	public void setupName(String name){}//item chests have no names
	public void setupLevel(int level){
		this.level = level;
	}
}
