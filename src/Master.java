import java.io.File;

class Master {
// // 	public void run(){
// // 		while (player.alive()){
// // 			event = room.getEvent(this.scene);
// // 			ioManager.showMessage(event.getInteraction() + " What will you do?");
// // 		}
// // 	}
	private Scenario scene;
	private Player p;
	private History history;
	public static IOManager ioManager;


	public Master(IOManager ioManager){
		try{
			this.ioManager = ioManager;
			scene = new Scenario(".");
			p = new Player("");
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
					room.getEvent().interacts(p);
				}while(history.hasContext());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
