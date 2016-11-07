import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidIp {

	public static void main(String[] args) {
		String ip[] = { "It has junk text", "121.18.19.20", "2001:0db8:85a3:0000:0000:8a2e:0370:7334"};
		String res[] = checkIP(ip);
		System.out.println(Arrays.toString(res));
	}

	private static String[] checkIP(String[] ip) {
		String res[] = new String[ip.length];
		String test = "";
		Pattern ipv4Pattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
		Pattern ipv6Pattern = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}");

		Matcher matcher;

		for (int i = 0; i < ip.length; i++) {
			test = ip[i];
			test = test.trim();
			if (test == null || test.isEmpty())
				res[i] = "Neither";
			else if ((test.length() < 6) & (test.length() > 15))
				res[i] = "Neither";
			else {
				// check ipv4
				if (ipv4Pattern.matcher(test).matches())
					res[i] = "IPv4";
				//check ipv6
				else if(ipv6Pattern.matcher(test).matches())
					res[i]= "IPv6";
				else
					res[i] = "Neither";
			}
		}
		return res;
	}

}
