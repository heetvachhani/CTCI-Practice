import java.util.Stack;

public class sortStack {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(15);
		s1.push(20);
		s1.push(2);
		s1.push(22);
		s1.push(10);
		sortMe(s1);

	}

	private static void sortMe(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();

		while (!s1.isEmpty()) {
			int tmp = s1.pop();
			while (!s2.isEmpty() && s2.peek() > tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		//System.out.println(s2.size());
		
		while(!s2.empty()){
			System.out.println(s2.pop());
		}
			
	}

}
