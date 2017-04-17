public class GridLand {

	public static void main(String[] args) {
		String[] ip = { "2 2 2", "2 2 3" };
		gridLand(ip);
	}

	public static int calcDistance(int a, int b) {
		int res = 1;
		int i = 1;
		for (i = 1; i <= (a + b); i++)
			res = res * i;
		for (i = 1; i <= a; i++)
			res = res / i;
		for (i = 1; i <= b; i++)
			res = res / i;
		return res;
	}

	public static void lexicogarohicalMinPath(int x, int y, int k, StringBuilder res) {
		if (x == 0 && y == 0)
			return;
		else if (x == 0) {
			y--;
			res.append("V");
			lexicogarohicalMinPath(x, y, k, res);
		} else if (y == 0) {
			x--;
			res.append("H");
			lexicogarohicalMinPath(x, y, k, res);
		} else {
			if (calcDistance(x - 1, y) > k) {
				res.append("H");
				lexicogarohicalMinPath(x - 1, y, k, res);
			} else {
				res.append("V");
				lexicogarohicalMinPath(x, y - 1, k - calcDistance(x - 1, y), res);
			}
		}
	}

	public static String[] gridLand(String[] inp) {
		String result[] = new String[inp.length];
		for (int i = 0; i < inp.length; i++) {
			String[] nums = inp[i].split(" ");
			int x = Integer.parseInt(nums[0]);
			int y = Integer.parseInt(nums[1]);
			int k = Integer.parseInt(nums[2]);
			StringBuilder sb = new StringBuilder();
			lexicogarohicalMinPath(x, y, k, sb);
			result[i] = sb.toString();
			System.out.println(sb.toString());
		}
		return result;
	}

}
