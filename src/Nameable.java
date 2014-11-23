import java.io.FileNotFoundException;
import java.io.IOException;

interface Nameable{
	void updateNames(Namer namer) throws FileNotFoundException, IOException;
}
