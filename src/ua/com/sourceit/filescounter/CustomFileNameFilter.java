package ua.com.sourceit.filescounter;

import java.io.File;
import java.io.FilenameFilter;

public class CustomFileNameFilter implements FilenameFilter {
	String extension;

	public CustomFileNameFilter(String extension) {
		this.extension = "." + extension;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.toLowerCase().endsWith(extension);
	}

}
