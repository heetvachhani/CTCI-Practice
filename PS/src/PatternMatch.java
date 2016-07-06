
public class PatternMatch {

	public static void main(String[] args) {
		String input = "abcddddddddbacdaabcdabcd";
		String pattern = "d*";
		char[] inputArray = input.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int patternIndex = 0;
		int resCount = 0;
		boolean flag = false;
		for (int i = 0; i < input.length(); i++) {
			System.out.println(inputArray[i] + " " + patternArray[patternIndex]);
			if (inputArray[i] == patternArray[patternIndex] || patternArray[patternIndex] == '*') {
				if (patternIndex + 1 == patternArray.length) {
					resCount++;
					i--;
					patternIndex = 0;
				} else
					patternIndex++;
				flag = true;
			} else {
				if (flag) {
					i--;
					flag = false;
				}
				patternIndex = 0;
			}
		}
		System.out.println(resCount);

	}

}
