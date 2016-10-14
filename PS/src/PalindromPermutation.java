
public class PalindromPermutation {
	/*
	 * write a function to check if it is a permutation of a palindrome To check
	 * check same char is even and one character could be odd. Input: Tact Coa
	 * Output: True (permutations:"taco cat'; "atco cta '; etc.)
	 */
	public static void main(String[] args) {
		int table[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

		String input = "TactCoa";
		int charNum = 0;
		int countOdd = 0;
		for (char c : input.toCharArray()) {
			charNum = getCharNumber(c);
			if (charNum != -1) {
				table[charNum]++;
				if (table[charNum] % 2 == 1)
					countOdd++;
				else
					countOdd--;
			}
		}

		if (countOdd <= 1)
			System.out.println("True!!");
		else
			System.out.println("Falase!!");

	}

	public static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);

		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

}
