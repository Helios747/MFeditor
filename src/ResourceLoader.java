
import java.io.*;

final public class ResourceLoader {
	
	public static InputStream load (String path) {
		InputStream in = ResourceLoader.class.getResourceAsStream(path);
		if (in == null) in = ResourceLoader.class.getResourceAsStream("/" + path);
		return in;
	} // end load()
	
} // end class ResourceLoader
