package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import interfaces.Readable;

public class InputReader implements Readable {

	private BufferedReader bufferedReader;
	private String path;
	
	public InputReader(String path) throws FileNotFoundException {
		bufferedReader = new BufferedReader(new FileReader(path));
		this.path = path;
	}

	@Override
	public void close() throws IOException {
		this.bufferedReader.close();
		bufferedReader = new BufferedReader(new FileReader(this.path));
		
	}

	@Override
	public String readLine() throws FileNotFoundException, IOException {
        String line = bufferedReader.readLine();
		return line;
	}


}
