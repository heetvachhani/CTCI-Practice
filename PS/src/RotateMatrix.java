
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		printMat(a);
		int n = 4;
		System.out.println("Left 90");
		rotateLeft(a, n);
		printMat(a);
		System.out.println("Right 90");
		rotateRight(a, n);
		printMat(a);
	}

	private static void printMat(int[][] a) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		System.out.println("\n");
	}

	private static void rotateRight(int[][] a, int n) {
		int tmp;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				tmp = a[j][n - i - 1];
				a[j][n - i - 1] = a[i][j];
				a[i][j] = a[n - j - 1][i];
				a[n - j - 1][i] = a[n - i - 1][n - j - 1];
				a[n - i - 1][n - j - 1] = tmp;
			}
		}
	}

	private static void rotateLeft(int[][] a, int n) {
		int tmp;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				tmp = a[i][j];
				a[i][j] = a[j][n - i - 1];
				a[j][n - i - 1] = a[n - i - 1][n - j - 1];
				a[n - i - 1][n - j - 1] = a[n - j - 1][i];
				a[n - j - 1][i] = tmp;
			}
		}

	}

}
