package interfaces;

import java.io.IOException;

public interface Writeable {
	void write(String path, String output) throws IOException;
}
