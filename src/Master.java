import java.io.File;

class Master {
// 	private Scenario scene;
// 	private Room room;
// 	private GeneratedEvent event;
// 	private Player player;
// 	
// 	Created to my own reference
// 	
// 	public Master(File file){
// 		this.scene = new Scenario(file);
// 		this.player = new Player(pickPlayerName());
// 		this.room = scene.getRoom(this.player.getLevel());
// 		Monster.addItselfRoom(room,7);
// 	}
// 	
// 	public String pickPlayerName(){
// 		// Ask for it
// 		return "Jao";
// 	}
// 	
// // 	public void run(){
// // 		while (player.alive()){
// // 			event = room.getEvent(this.scene);
// // 			System.out.println(event.getInteraction() + " What will you do?");
// // 		}
// // 	}
	
	public static void main(String[] args){
	//	Master m = new Master(new File("/"));
		try{
			Scenario scene = new Scenario(".");
			Player p = new Player("Sr. Cobaia");
			Room room = new Room(scene,p.getLevel());
			Monster m = (Monster)room.getEvent();
			Combat c = new Combat(p,m);
			c.fight();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
