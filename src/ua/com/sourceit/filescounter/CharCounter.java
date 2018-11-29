package ua.com.sourceit.filescounter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharCounter {
	TreeMap<Integer, Character> countChar = null;
	private File file;

	public CharCounter(File file) {
		this.file = file;
	}

	public void countChars() {
		TreeMap<Integer, Character> treeMap = null;
		HashMap<Character, Integer> countCharLocal = null;
		try (FileReader fileReader = new FileReader(file);) {
			char[] chars = new char[(int) file.length()];
			fileReader.read(chars, 0, (int) file.length());

			List<Character> list = new ArrayList();

			for (char c : chars) {
				list.add((Character) c);
			}

			countCharLocal = list.stream().collect(HashMap<Character, Integer>::new, (m, c) -> {
				if (c != null && !c.equals("") && !c.equals(" ") && c.toString().matches("[A-Za-z]"))
					if (m.containsKey(c))
						m.put(c, m.get(c) + 1);
					else
						m.put(c, 1);
			}, HashMap<Character, Integer>::putAll);

			treeMap = new TreeMap<Integer, Character>();
			for (Entry<Character, Integer> entry : countCharLocal.entrySet())
				treeMap.put(entry.getValue(), entry.getKey());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (treeMap != null)
			printReport(treeMap);
	}

	private void printReport(TreeMap<Integer, Character> toPrint) {

		for (Entry<Integer, Character> item : toPrint.entrySet()) {
			System.out.println(item.getKey() + " - " + item.getValue());
		}

	}
}
