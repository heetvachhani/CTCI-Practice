import java.util.HashMap;

public class RomanToNumeric {

	public static void main(String[] args) {
		String input = "XCVII";
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
		int currentNum = 0;
		int count = 0;
		int prevVal = 0;
		int res = 0;
		char values[] = input.toCharArray();
		for (char i : values) {
			if (count != 0) prevVal = numericalValues.get(values[count - 1]);
			currentNum = numericalValues.get(i);
			//System.out.println(prevVal + ":" + currentNum);
			count++;
			if (values.length == count) {
				if(prevVal == 0) res = currentNum;
				else if(prevVal >= currentNum) res += currentNum;
				else if(prevVal < currentNum)res += currentNum -2*prevVal;
				
			}
			else{ 
				if(prevVal < currentNum )res =currentNum -res;
				else res += currentNum;
			};

		}
		return res;
	}

}
