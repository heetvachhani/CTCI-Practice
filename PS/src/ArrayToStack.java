import java.lang.Math;
public class ArrayToStack {
	static int stacksize = 100;
	static int data[] = new int[stacksize*3];
	static int stkpntr[] = {-1,-1,-1};
	
	public static void main(String[] args) {
			push(0,11);
			push(0,12);
			//System.out.println(pop(0));
			push(0,13);
			printStack(0);
			
			push(1,2);
			push(1,221);
			push(1,222);
			push(1,21);
			System.out.println(stkpntr[1]);
			//push(2,33);
			printStack(1);
			
			//printStack(2);
			
			
	}

	static void push(int stkno, int val){
		if(stkpntr[stkno]+1>stacksize){	
			System.out.println("This stack is full so use another one...");
			System.exit(0);// throw exception
		}
		stkpntr[stkno]++;
		data[enterData(stkno)] = val;	
	}
	
	static int pop(int stkno){
		if(stkpntr[stkno]<0){
			System.out.println("Stack is empty Cant remove anymore...");
			System.exit(0);
		}
		int val = data[enterData(stkno)];
		data[enterData(stkno)] = 0;
		stkpntr[stkno]--;
		return val;
	}

	static void printStack(int stkno){
		for(int i=stkpntr[stkno];i>=0;i--){
			System.out.println(data[Math.abs(stkno*stacksize+i)]);
		}
	}
	
	  static int enterData(int stkno) {
		return stkno*stacksize + stkpntr[stkno];
	}
}
