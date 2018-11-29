package ua.com.sourceit.filescounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesCounter {

	public FilesCounter() {
	}

	public void countFiles(String root, String extension) {
		int numberOfFiles = countFile(new File(root), extension);
		System.out.println(numberOfFiles);
	}

	private int countFile(File root, String extension) {
		int numberOfFiles = 0;
		File[] listOfFiles = root.listFiles();
		for (File item : listOfFiles) {
			if (item.isDirectory())
				countFile(item, extension);
			else if (item.getName().toLowerCase().endsWith(extension))
				numberOfFiles++;
		}
		return numberOfFiles;
	}

	public void countJAVAFiles(String root, int depth) {
		File file = new File(root);
		StringBuilder sb = new StringBuilder();
		try (Stream<Path> stream = Files.walk(file.toPath(), depth, FileVisitOption.FOLLOW_LINKS);) {
			stream.filter(item -> item.getFileName().toString().endsWith("java"))
					.forEach(element -> sb.append(element.getFileName().toString()));
			System.out.println(sb.toString());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void countJavaFiles(String root, int depth) {
		File file = new File(root);
		StringBuilder sb = new StringBuilder();

		try (Stream<Path> stream = Files.find(file.toPath(), depth,
				(path, basicFileAttributes) -> path.getFileName().toString().endsWith("java"),
				FileVisitOption.FOLLOW_LINKS);) {
			stream.forEach(element -> sb.append(element.getFileName().toString()));
			System.out.println(sb.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
