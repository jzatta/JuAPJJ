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
// // 			ioManager.showMessage(event.getInteraction() + " What will you do?");
// // 		}
// // 	}
	private Scenario scene;
	private Player p;
	private History history;
	IOManager ioManager;


	public Master(IOManager ioManager){
		try{
			this.ioManager = ioManager; 
			scene = new Scenario(".");
			p = new Player("Sr. Cobaia");
			history = scene.getHistory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean initialMenu(){
		ioManager.showMessage("What do you want to do?\n1) New game\n2) Load game\n3) Exit");
		switch(ioManager.getCommand()){
			case 1:
				String playerName = ioManager.getString("What's your player name?");
				p = new Player(playerName);
				break;
			case 2:
				//Game game = new Game();
				break;
			case 3:
				//Game game = new Game();
				return false;
		}
		return true;
	}
	
	public void run(){
		try{
			while(initialMenu()){
				do{
					Room room = new Room(scene,p.getLevel());
					for(int i = 0; i < history.context().eventNames().size(); i++){
						Class<GeneratedEvent> genClass = (Class<GeneratedEvent>)Class.forName(history.context().eventNames().get(i));
						room.addGeneratedEvent(genClass,scene.namesListFor(genClass),history.context().evtPotentials().get(i));
					}
					ioManager.showMessage(history.context().plot());
					GeneratedEvent evt = room.getEvent();
					Combat c = new Combat(ioManager,p,(Monster)evt);
					c.fight();
				}while(history.hasContext());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
