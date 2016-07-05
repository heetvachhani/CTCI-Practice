import java.lang.reflect.Array;
import java.util.Arrays;

public class median2Array {

	public static void main(String[] args) {
		int a[] = { 1, 15, 17, 22, 23 };
		int b[] = { 2, 16, 20, 22, 24 };

		findMedian(a, b);
		// 1, 2,15,16,17,20,22,22,24
	}

	private static void findMedian(int[] a, int[] b) {
		double amed, bmed;

		if (a.length == 2 && b.length == 2) {
			System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
			System.out.println("median =" + (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2);
			System.exit(0);
		}

		if (a.length % 2 != 0)
			amed = a[a.length / 2];

		else {
			amed = (a[a.length / 2] + a[(a.length / 2) - 1]) * 0.5;
		}

		if (b.length % 2 != 0)
			bmed = b[b.length / 2];

		else {
			bmed = (b[b.length / 2] + b[(b.length / 2) - 1]) * 0.5;
		}

		if (amed == bmed) {
			System.out.println("Median is=" + amed);
			System.exit(0);
		}
		int l = (int) (a.length / 2.0);
		int k = (int) (b.length / 2.0);

		if (amed > bmed) {
			a = Arrays.copyOfRange(a, 0, l);
			b = Arrays.copyOfRange(b, k, b.length);
			// System.out.println(Arrays.toString(a));
		} else {
			a = Arrays.copyOfRange(a, l, a.length);
			b = Arrays.copyOfRange(b, 0, k);
		}
		System.out.println(amed + " " + bmed);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		findMedian(a, b);

	}

}
