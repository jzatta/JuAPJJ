import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

class Master {
// // 	public void run(){
// // 		while (player.alive()){
// // 			event = room.getEvent(this.scene);
// // 			ioManager.showMessage(event.getInteraction() + " What will you do?");
// // 		}
// // 	}
	private Scenario scene;
	private Player player;
	private History history;
	public static IOManager ioManager;
	private final String playerSerFilePath = "player.ser";
	private final String historySerFilePath = "history.ser";


	public Master(IOManager ioManager){
		try{
			this.ioManager = ioManager;
			scene = new Scenario(".");
			player = new Player("");
			history = scene.getHistory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void serializes(Object obj, String filePath){
		try{
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream outStream = new ObjectOutputStream(file);
			outStream.writeObject(obj);
			outStream.close();
			file.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Object unSerializes(String filePath){
		try{
			FileInputStream file = new FileInputStream(filePath);
			ObjectInputStream inStream = new ObjectInputStream(file);
			Object obj = inStream.readObject();
			inStream.close();
			file.close();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void loadGame(){
		player = (Player)unSerializes(playerSerFilePath);
		history = (History)unSerializes(historySerFilePath);
	}

	public void saveGame(){
		serializes(player,playerSerFilePath);
		serializes(history,historySerFilePath);
	}
	public boolean initialMenu(){
		ioManager.showMessage("What do you want to do?\n1) New game\n2) Load game\n3) Exit");
		switch(ioManager.getCommand()){
			case 1:
				String playerName = ioManager.getString("What's your player name?");
				player = new Player(playerName);
				history.reset();
				break;
			case 2:
				loadGame();
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
					Room room = scene.generateRoom(player.getLevel());
					for(int i = 0; i < history.context().eventNames().size(); i++){
						Class<GeneratedEvent> genClass = (Class<GeneratedEvent>)Class.forName(history.context().eventNames().get(i));
						int potential = history.context().evtPotentials().get(i);
						GeneratedEvent genEvt = genClass.newInstance();
						scene.addNameable((Nameable)genEvt);
						genEvt.addItselfRoom(room,potential);
					}
					ioManager.showMessage("You are now in room " + room.roomName());
					ioManager.showMessage(history.context().plot());
					room.getEvent().interacts(player);
					saveGame();
				}while(history.hasContext() && player.isAlive());
			}
			System.exit(0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
