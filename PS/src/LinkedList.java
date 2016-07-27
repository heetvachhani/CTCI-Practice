import java.util.ArrayList;
import java.util.HashMap;

class Node {
	Node next = null;
	int data;

	Node(int d) {
		data = d;
	}
}

public class LinkedList {

	static Node head;

	public static void main(String[] args) {

		appendTail(1);
		appendTail(5);
		appendTail(12);
		appendTail(5);
		appendTail(11);
		appendTail(5);
		appendTail(11);

		printList(head);
		// head = deleteData(5, head);

		// printList(head);
		// head = deleteIndex(3, head);
		// printList(head);

		head = removeduplicate(head);
		printList(head);
	}

	private static Node removeduplicate(Node head) {
		//HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
		ArrayList<Integer> aa= new ArrayList<Integer>();
		Node n = head;
		Node prev = head;
		while (n!= null) {
			if(aa.contains(n.data)){
				prev.next=n.next;
				n=prev;
				
			}
			else{
				aa.add(n.data);
			}
			prev=n;
			n=n.next;
		}
		return head;
	}

	// private static Node removeduplicate(Node head) {
	// Node n1 = head;
	// Node n;
	// Node prev;
	// int val;
	// while (n1.next!= null) {
	// n=n1.next;
	// val = n1.data;
	// prev=n1;
	// while (n != null) {
	// System.out.println(val+": "+n.data);
	// if (val == n.data) {
	// prev.next =n.next;
	// n=prev.next;
	// }
	// else{
	// prev=n;
	// n = n.next;
	// }
	// }
	// n1 = n1.next;
	// }
	//
	// return head;
	// }
	//
	static void appendTail(int d) {
		Node end = new Node(d);
		if (head == null) {
			head = end;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}

	static Node deleteData(int d, Node head) {
		Node n = head;

		if (n.data == d) {
			return head.next;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;

		}
		return head;
	}

	private static Node deleteIndex(int index, Node head) {
		Node n = head;
		int i = 1;
		if (i == index)
			return head.next;
		else {
			while (n.next != null) {
				i++;
				if (i == index) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;

			}
		}
		return head;
	}

	static void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(" "+n.data);
			n = n.next;
		}
		System.out.println();
	}
}
