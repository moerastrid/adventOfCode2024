package aoc2025;

import java.util.List;

import aoc2025.util.InputReader;

public class dayTwo_exOne {
	static private String path = "inputTwo.txt";
	static boolean increasing = false;
	static boolean decreasing = false;

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
			increasing = false;
			decreasing = false;
			int returnval = issafe(strList.getFirst());
			System.out.println("ret val: " + returnval + "\n");
			answer += returnval;
			
			strList.removeFirst();
		}
		return answer;
	}

	static private int issafe(String str) {
		int safe = 1;
		String[] strArray = str.split(" ");

		System.out.println("start: " + strArray[0] + " " + strArray[1]);
		
		boolean skipped = false;
		for(int i = 0; safe == 1 && (i < strArray.length - 1); i++) {
			boolean tempIncreasing = increasing;
			boolean tempDecreasing = decreasing;
			Integer current = Integer.parseInt(strArray[i]);
			Integer next = Integer.parseInt(strArray[i + 1]);
			Integer third = -1;
			if (i < strArray.length - 2) {
				third = Integer.parseInt(strArray[i + 2]);
			}

			if (smallissafe(current, next) == 1)
				safe = 1;
			else if (third != -1 && skipped == false) {
				increasing = tempIncreasing;
				decreasing = tempDecreasing;
				skipped = true;
				safe = smallissafe(current, third);
				i++;
			} else {
				safe = 0;
			}
		}
		System.out.println(" safe: " + safe);
		return safe;
	}

	static private int smallissafe(Integer current, Integer next) {
		switch (current.compareTo(next)) {
			case 0 :
				// System.out.println("same");
				return 0;

			case 1 :
				// System.out.println("decreasing");
				decreasing = true;
				if (current - next > 3)
					return 0;
				break;

			case -1 :
				// System.out.println("increasing");
				increasing = true;
				if (next - current > 3)
					return 0;
				break;
		}

		if (increasing == true && decreasing == true) {
			return 0;
		}

		return 1;
	}
}


// tries: 521 - too high!
// tries: 416 - too high!
// tries: 400 - too high!
// tries: 237 - not right!