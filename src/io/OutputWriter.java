package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import interfaces.Writeable;

public class OutputWriter implements Writeable {

	@Override
	public void write(String path, String output) throws IOException {
		 try (PrintWriter writer = new PrintWriter(new FileWriter(path, true), true)) {
	            writer.print(output);
	            writer.println();
		 }
		
	}


}
