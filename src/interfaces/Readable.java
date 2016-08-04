package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This interface defines the behavior of the objects that will read lines.
 */
public interface Readable extends Closeable {
	
	/**
	 * This method returns the read lines.
	 * @return text in a line which has been read.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	String readLine() throws FileNotFoundException, IOException;
}
