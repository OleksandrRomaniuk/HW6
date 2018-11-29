package ua.com.sourceit.filescounter;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		FilesCounter f = new FilesCounter();
		f.countFiles("\\Users\\Oleksandr Romaniuk\\eclipse-workspace\\FilesCounter", "txt");
		f.countJAVAFiles("\\Users\\Oleksandr Romaniuk\\eclipse-workspace\\FilesCounter", 1);
		f.countJavaFiles("\\Users\\Oleksandr Romaniuk\\eclipse-workspace\\FilesCounter", 100);

		CharCounter charCounter = new CharCounter(
				new File("\\Users\\Oleksandr Romaniuk\\eclipse-workspace\\FilesCounter\\test.TXT"));
		charCounter.countChars();

	}

}
