package rpg.system;

public class PlayerClass {
	
	private int classID;
	private String className;
	
	public PlayerClass(int classID){
		this.classID = classID;
		generateClass(classID);
		className = "Test";
	}
	public String toString(){
		return classID + "\n" + className;
	}
	
	public void generateClass(int id){
		switch(id){
		case 0:
			this.className = "Aprendiz";
			break;
		case 1: 
			this.className = "Guerreiro";
			break;
		case 2:
			this.className = "Mago";
			break;
		}
	}

}
