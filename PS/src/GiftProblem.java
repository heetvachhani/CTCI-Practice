
/*
# Maximal Value of Gifts
# ----------------------
# Question: A board has n*m cells, and there is a gift with some value (value is
# greater than 0) in every cell. You can get gifts starting from the top-left
# cell, and move right or down in each step, and finally reach the cell at the
# bottom-right cell. What’s the maximal value of gifts you can get from the
# board?
#
#  *1 10   3  8
# *12  2   9  6
#  *5 *7   4 11
#   3 *7 *16 *5
#
# For example, the maximal value of gift from the board above is 53, and the path is
# highlighted with stars.


    int[][] board = {
      {1, 10, 3, 88},
      {12, 2, 9, 6},
      {5, 7, 4, 11},
      {3, 7, 16, 5}
    };

    System.out.println(maxValueGifts(board));
*/

class GiftProblem {
	public static void main(String[] args) {

		int[][] board = { { 1, 10, 3, 88 }, { 12, 2, 9, 6 }, {99, 7, 4, 11 }, { 3, 7, 16, 5 } };

		System.out.println(maxValueGifts(board));

		// ArrayList<String> strings = new ArrayList<String>();
		// Scanner sc = new Scanner(System.in);
		// String no=sc.nextLine();
		// System.out.println(no);
	}

	public static int maxValueGifts(int[][] values) {
		int sizex = values.length;
		int sizey = values[0].length;
		int[][] sum = new int[sizex][sizey];
		for (int i = 0; i < sizex; i++) {
			for (int j = 0; j < sizey; j++) {
				if (i == 0 && j == 0) {
					sum[i][j] = values[i][j];
				} else if (i == 0) {
					sum[i][j] = sum[i][j - 1] + values[i][j];
				} else if (j == 0) {
					sum[i][j] = sum[i - 1][j] + values[i][j];
				} else {
					sum[i][j] = Math.max(sum[i][j - 1], sum[i - 1][j]) + values[i][j];
				}
				System.out.print(sum[i][j]+"\t");
				
			}System.out.println();
		}
		// sum=sum+values[x][y];
		return sum[sizex - 1][sizey - 1];
	}
}
