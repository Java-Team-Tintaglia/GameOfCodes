package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable extends Closeable {
	String readLine() throws FileNotFoundException, IOException;
}
