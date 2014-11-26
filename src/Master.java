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


	public Master(IOManager ioManager){
		try{
			Master.ioManager = ioManager;
			scene = new Scenario(".");
			player = new Player("");
			history = scene.getHistory();
			scene.addNameable(new Item());
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
	}

	public void saveGame(){
		serializes(player,playerSerFilePath);
	}
	public boolean initialMenu(){
		ioManager.clearScreen();
		ioManager.showMessage("O que você deseja fazer?\n1) Novo jogo\n2) Carregar jogo\n3) Sair");
		switch(ioManager.getCommand()){
			case 1:
				ioManager.clearScreen();
				String playerName = ioManager.getString("Qual o nome do seu jogador?");
				player = new PlayerCheat(playerName);
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
        //    MusicPlayer mPlayer = new MusicPlayer("../resources/music.wav");
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
					ioManager.clearScreen();
					ioManager.showMessage("Você está na sala " + room.roomName());
					ioManager.waitInteraction();
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
