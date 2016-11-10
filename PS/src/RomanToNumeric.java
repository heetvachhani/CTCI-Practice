import java.util.HashMap;

public class RomanToNumeric {

	public static void main(String[] args) {
		String input = "XLIX"; 
		int result = convertRomanToNumeric(input);
		System.out.println(result);

	}

	private static int convertRomanToNumeric(String input) {
		HashMap<Character, Integer> numericalValues = new HashMap<Character, Integer>();
		numericalValues.put('I', 1);
		numericalValues.put('V', 5);
		numericalValues.put('X', 10);
		numericalValues.put('L', 50);
		numericalValues.put('C', 100);
		numericalValues.put('D', 500);
		numericalValues.put('M', 1000);

		int prevVal = 0;
		char ch[] = input.toCharArray();
		int currentNum = 0;
		int res = numericalValues.get(ch[ch.length - 1]);

		for (int i = ch.length - 1; i > 0; i--) {
			currentNum = numericalValues.get(ch[i]);
			prevVal = numericalValues.get(ch[i - 1]);
			
			if (prevVal < currentNum)
				res = Math.abs(res - prevVal);
			else
				res = res + prevVal;
		}
		return res;
	}
}
