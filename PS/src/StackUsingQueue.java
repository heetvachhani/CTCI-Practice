import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;;

public class StackUsingQueue {
	public static void main(String[] args) {
		// stack using 2 queues
		MyStack<Integer> st = new MyStack<>();
		st.push(10);
		st.push(15);
		st.push(20);
		System.out.println(st.pop());
		System.out.println(st.peek());
		
		// queue using 2 stacks
		MyQueue<Integer> qu = new MyQueue<>();
		
	}
}

class MyStack<T> {
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> tmp = new LinkedList<Integer>();

	public void push(int data) {
		if (q.size() == 0)
			q.add(data);
		else {
			/*
			 * if elements are present in q then dequeue all the elements to
			 * temporary queue tmp
			 */
			int l = q.size();
			for (int i = 0; i < l; i++)
				tmp.add(q.remove());
			/* enqueue the new element into q */
			q.add(data);
			/*
			 * dequeue all the elements from temporary queue tmp to q
			 */
			for (int i = 0; i < l; i++)
				q.add(tmp.remove());
		}
	}

	public int pop() {
		if (q.size() == 0)
			throw new NoSuchElementException("Underflow Exception");
		return q.remove();
	}

	public int peek() {
		if (q.size() == 0)
			throw new NoSuchElementException("Underflow Exception");
		return q.peek();
	}

	public boolean isEmpty() {
		return q.size() == 0;
	}

	public int getSize() {
		return q.size();
	}

	public void display() {
		System.out.print("\nStack = ");
		int l = getSize();
		if (l == 0)
			System.out.print("Empty\n");
		else {
			Iterator it = q.iterator();
			while (it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		}
	}
}

class MyQueue<T> {
	 
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();
 
    // Push element x to the back of queue.
    public void push(int x) {
        if(value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                temp.push(value.pop());
            }
 
            value.push(x);
 
            while(!temp.isEmpty()){
                value.push(temp.pop());
            }    
        }
    }
 
    // Removes the element from in front of queue.
    public void pop() {
        value.pop();
    }
 
    // Get the front element.
    public int peek() {
        return value.peek();
    }
 
    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}
