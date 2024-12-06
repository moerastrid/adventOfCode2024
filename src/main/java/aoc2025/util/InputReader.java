package aoc2025.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
	private File file;
	private String path;
	private BufferedReader br;

	public InputReader(String _path) {
		this.path = _path;
		this.file = new File(path);
	}

	public List<Integer> convertFileToIntegerList() {
		List<Integer> inputList = new ArrayList<>();

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (IOException error) {
		}

		return inputList;
	}
}
