
public class uniqueString {

	public static void main(String[] args) {
		String test = "abcd";
		boolean flag=false;
		boolean[] c= new boolean[256];
		for(int i=0;i<test.length();i++){
			int val = test.charAt(i);
			if(c[val]){
				flag=true;
			}
			c[val]=true;
			
		}
		
		
		// or you can jut sort out element and just check neighbour 
		//char a[]= test.toCharArray();
		//java.util.Arrays.sort(a);  nlgn
		
		
//		char[] a = test.toCharArray();
//		int c=0;
//		while (c < a.length) {
//			
//			for (int i = c+1; i < a.length; i++) {
//				if(a[c]==a[i]){
//					flag=true;
//				}
//			}
//			c++;
//		}
		if(flag)
			System.out.println("Not unique");
		else{
			System.out.println("Unique");
		}
	}

}
