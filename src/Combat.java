public class Combat implements GeneratedEvent{
	private Player player;
	private Monster monster;

	public Combat(Player p, Monster m){
		player = p;
		monster = m;
	}
	boolean active(){
		if(player.getCurrentHp >0 && monster.getCurrentHp > 0){
	
	}
    boolean damage(int damage){}
    int attack(){}
  	boolean dropsItem(int luck){}
	Item pickUpItem(int luck){}
    String getInteraction(){}

} 
