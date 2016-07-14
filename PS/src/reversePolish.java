import java.util.Stack;

public class reversePolish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = new String[] {"4", "13", "5", "/", "+"};
		
		Stack<String> stack = new Stack<String>();
		String op="+-/";
		int a,b;
		int res;
		for(int i=0;i<tokens.length;i++){
			if(!op.contains(tokens[i])){
				stack.push(tokens[i]);
			}
			else{
				b= Integer.parseInt(stack.pop());
				a=Integer.parseInt(stack.pop());
				res=a/b;
				System.out.println(a+" "+tokens[i]+" "+b);
				stack.push(String.valueOf(res));
			}
		}
		

		
	}

}
