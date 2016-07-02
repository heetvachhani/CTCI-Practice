
public class compressString {

	public static void main(String args[]) {
		String s = "aaabcdeee";
		int cnt = 1;
		char tmp = ' ';
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			tmp = s.charAt(i);
			if (i == s.length()-1) {
				res.append(tmp);
				res.append(cnt);
				cnt=1;
				}

			else if (s.charAt(i) == s.charAt(i + 1)) {
				cnt++;
			} else {
				res.append(tmp);
				res.append(cnt);
				cnt=1;
			}
		}
		System.out.println(res);

	}

}
