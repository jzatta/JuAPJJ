public class Trap implements GeneratedEvent{	
	Scenario scene;
	int level; //not sure if we will use this.
	boolean interacted;

	public Trap(Scenario scene, int level){
		this.scene = scene;
		this.level = level;
		this.interacted = false;
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
		return false;
	}
	public Item pickUpItem(int luck){
		return null; // luck won't be needed since the chest was already found?
	}
	public String getInteraction(){
		return "You found an item chest!";
	}
	public void setupName(String name){}//Traps have no names
	public void setupLevel(int level){
		this.level = level;
	}
	public void interacts(Player player){
		if (interacted == false){
			player.damage(Math.random() * (15 + (level * 0.6)));
			this.interacted = true;
// 		Formula: Math.random() * (150 + (level * 0.2 * 3 * 10) * 0.1)
// 		Math.random()[random] * 
// 		(150[start hp player] + 
// 			(level * 0.2[tax of vit points used per levelUp] *
// 			3[points increased in vit points when levelUp] *
// 			10[multiply factor of vit points to hp])
// 		) *
// 		0.1[10% of player hp]
		}
	}
}
