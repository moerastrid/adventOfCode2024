package aoc2025;

import java.util.List;

import aoc2025.util.InputReader;

public class dayTwo_exOne {
	static private String path = "exampleTwo.txt";
	public static void main(String[] args) {

		if (args.length == 1) {
			path = args[0];
		} else {
			System.out.println("INFO - Please provide input file! Now using example input (exampleTwo.txt)");
		}

		InputReader inputReader = new InputReader(path);
		List<String> input = inputReader.convertFileToStringList();
		// String[] inputArray = input.split(" ");
		System.out.println(input);

		int answer = calculate(input);
		System.out.println("THe ansWer: " + answer);
	}

	static private int calculate(List<String> strList) {
		int answer = 0;

		while (!strList.isEmpty()) {
			answer += issafe(strList.getFirst());
			strList.removeFirst();
		}

		return answer;
	}

	static private int issafe(String str) {
		int safe = 1;
		String[] strArray = str.split(" ");
		
		for(int i = 0; i < strArray.length; i++) {
			System.out.println("strArray[" + i + "]: " + strArray[i]);
		}
		return safe;
	}
}
