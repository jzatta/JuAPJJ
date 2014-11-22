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
			History history = scene.getHistory();
			//history.eventsNames();
			do{
				Room room = new Room(scene,p.getLevel());
				for(int i = 0; i < history.context().eventNames().size(); i++){
					Class<GeneratedEvent> genClass = (Class<GeneratedEvent>)Class.forName(history.context().eventNames().get(i));
					room.addGeneratedEvent(genClass,scene.namesListFor(genClass),history.context().evtPotentials().get(i));
				}
				System.out.println(history.context().plot());
				GeneratedEvent evt = room.getEvent();
				Combat c = new Combat(p,(Monster)evt);
				c.fight();
			} while(history.hasContext());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
