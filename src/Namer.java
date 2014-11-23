import java.io.FileNotFoundException;
import java.io.IOException;

interface Namer{
	boolean addNameable(Nameable nameable) throws FileNotFoundException, IOException;
	NameGenerator namesListFor(Class<?> toSearch) throws FileNotFoundException, IOException;

}
