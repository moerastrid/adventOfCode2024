package aoc2025.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
	final private File file;
	final private String path;
	private String str;
	private BufferedReader br;

	public InputReader(String _path) {
		this.path = _path;
		this.file = new File(path);
	}

	// public List<Integer> convertFileToIntegerList() {
	// 	List<Integer> inputList = new ArrayList<>();

	// 	try {
	// 		br = new BufferedReader(new FileReader(file));
	// 		while((str = br.readLine()) != null) {
	// 			inputList.add(Integer.parseInt(str));
	// 		}
	// 	} catch (IOException error) {
	// 		error.printStackTrace();
	// 	}
	// 	return inputList;
	// }

	public List<String> convertFileToStringList() {
		List<String> stringList = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
				stringList.add(str);
			}
		} catch (IOException error) {
			error.printStackTrace();
		}
		return stringList;
	}
}
