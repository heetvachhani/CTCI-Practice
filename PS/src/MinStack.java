import java.util.Stack;
//finding minimum value of stack in O(1) time
public class MinStack extends Stack<Integer> {
	
	Stack<Integer> s2;
	public MinStack() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int val){
		if(val<= min())
			s2.push(val);
		super.push(val);
	}
	
	private int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}

	public Integer pop(){
		int val = super.pop();
		if(val==min())
			s2.pop();
		return val;
	}
	public static void main(String[] args) {
			MinStack m = new MinStack();
			m.push(11);
			m.push(22);
			m.push(33);
			m.push(2);
			m.push(4);
			m.pop();
			//m.pop();
			//m.pop();
			System.out.println(m.s2.peek());
	}
}
