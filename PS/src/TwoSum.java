import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TwoSum {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 8, 15, 3, 10, 4 };
		int target = 7;
		HashSet<Integer> poss = new HashSet<Integer>(); // hash set iterate using iterator
		System.out.println(Arrays.toString(arr));
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= target) {
				poss.add(arr[i]);
			}
		}
		
		Iterator<Integer> it= poss.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		checkpossible(poss, target);

	}

	private static void checkpossible(HashSet<Integer> poss, int target) {
		
	}

}
