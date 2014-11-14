import java.io.File;

class Master {
	private Scenario scene;
	private Room room;
	private GeneratedEvent event;
	private Player player;
	
	// Created to my own reference
	
	public Master(File file){
		this.scene = new Scenario(file);
		this.player = new Player(pickPlayerName());
		this.room = scene.getRoom(this.player.getLevel());
		event = room.getEvent(this.scene);
	}
	
	public String pickPlayerName(){
		// Ask for it
		return "Jao";
	}
	
	public void run(){
		while (player.alive()){
			event = room.getEvent(this.scene);
			System.out.println(event.getInteraction() + " What do you will do?");
		}
	}
	
	public static void main(){
		Master m = new Master(new File("/"));
	}
}