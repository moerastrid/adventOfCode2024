package aoc2025;

import aoc2025.util.InputReader;

public class dayTwo_exOne {
	static private String path = "example.txt";

	public static void main(String[] args) {

		if (args.length == 1) {
			path = args[0];
		} else {
			System.out.println("INFO - Please provide input file! Now using example input (example.txt)");
		}

		InputReader inputReader = new InputReader(path);
		inputReader.convertFileToIntegerList();
	}
}
