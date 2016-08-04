package interfaces;

import java.io.IOException;

/**
 * This interface provides behavior for the objects that would be closed.
 */
public interface Closeable {
	void close() throws IOException;
}
