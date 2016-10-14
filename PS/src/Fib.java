
public class Fib {
	// generating fib using memoization -> optimal way to do exponential algo like this 
	// complexity will be O(n) 
	public static void main(String[] args) {
		allFib(10);
	}

	public static void allFib(int n) {
		int[] memo = new int[n + 1];
		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + fib(i, memo));
		}
	}

	public static int fib(int n, int[] memo) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (memo[n] > 0)
			return memo[n];

		memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
		return memo[n];
	}
}
