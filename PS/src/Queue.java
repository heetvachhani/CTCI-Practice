
public class Queue {
	static Node first;
	Node last;

	void enqueue(int item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}

	}

	int dequeue() {
		if (first != null) {
			int data = first.data;
			first = first.next;
			return data;
		}
		return 0;
	}

	static void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue qu = new Queue();
		qu.enqueue(11);
		qu.enqueue(22);
		qu.enqueue(2);
		qu.enqueue(12);
		qu.dequeue();
		printList(first);

	}

}
