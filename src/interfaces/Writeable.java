package interfaces;

import java.io.IOException;

/**
 * This interface defines the behavior of the objects that will write lines on some path directory.
 */
public interface Writeable {
	
	/**
	 * This method writes some output on a certain path directory.
	 * @param path - the directory on which the output will be written.
	 * @param output - the text which will be written on the path.
	 * @throws IOException when cannot write on the file or file is not found.
	 */
	void write(String path, String output) throws IOException;
	
}
