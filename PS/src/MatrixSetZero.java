import java.util.ArrayList;

public class MatrixSetZero { // set zero row and column when you encounter zero
								// in matrix

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 0, 1 }, { 3, 0, 4, 1 } };
		boolean row[] = new boolean[arr.length];
		boolean col[] = new boolean[arr[0].length];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]);
				if (arr[i][j] == 0) {
					row[i] = true;
					col[j] = true;

				}
			}
			System.out.println();
		}

		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < col.length; j++) {
				if (row[i] || col[j]) {
					arr[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

}
