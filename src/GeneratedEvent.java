import java.io.FileNotFoundException;
import java.io.IOException;

interface GeneratedEvent{
	boolean active();
	boolean damage(int damage);
	int attack();
	boolean dropsItem(int luck);
	String getInteraction();
	
	void setupName(String name);
	void setupLevel(int level);
	void setupNamer(Namer namer) throws FileNotFoundException, IOException;
	void interacts(Player player);
	void addItselfRoom(Room room, int potential);
}
