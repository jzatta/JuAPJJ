package rpg.system;

public enum PlayerClass {
	Aprendiz(0), Guerreiro(1), Mago(2);
	private final int id;

	PlayerClass(int id){
		this.id = id;
	}
}
