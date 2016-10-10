import java.util.Scanner;
import java.util.Stack;

class TreeNode {
	String data;
	TreeNode child;
	TreeNode parent;
	TreeNode sibling;

	public TreeNode(String data) {
		this.data = data;
		child = null;
		parent = null;
		sibling = null;
	}

	public void addChild(TreeNode child) {
		this.child = child;
	}

	public void addParent(TreeNode parent) {
		this.parent = parent;
	}

	public void addSibling(TreeNode sibling) {
		this.sibling = sibling;
	}
}

public class TreeClosestPeer {
	public static TreeNode root;
	// temporary stack for adding child and parent link;
	Stack<TreeNode> childStack = new Stack<TreeNode>();

	public TreeClosestPeer() {
		root = null;
	}

	public void insert(String data, boolean childFlag) {
		TreeNode n = getNode(root, data);
		if (n == null)
			n = new TreeNode(data);

		if (!childStack.isEmpty() && root != null) {
			TreeNode p = childStack.pop();
			p.addChild(n);
			n.addParent(p);
		}

		if (childFlag) {
			childStack.push(n);
		}

		if (root == null) {
			root = n;
		}
	}

	public void addSibling(String data1, String data2) {
		TreeNode siblingTo = getNode(root, data1);
		TreeNode siblingOf = new TreeNode(data2);
		siblingTo.addSibling(siblingOf);
	}

	public void addParentLink(String child, String parent) {
		TreeNode child1 = getNode(root, child);
		TreeNode parent1 = getNode(root, parent);
		child1.addParent(parent1);

	}

	private TreeNode getNode(TreeNode root, String element) {
		if (root != null) {
			if (root.data.equals(element)) {
				return root;
			} else {
				TreeNode res;
				if (root.sibling != null) {
					res = getNode(root.sibling, element);
					if (res != null && element.equals(res.data))
						return res;
				}
				if (root.child != null) {
					res = getNode(root.child, element);
					if (res != null && element.equals(res.data))
						return res;
				}
			}
		}
		return null;
	}

	boolean flag = false;

	public void getClosestPeer(String input) {
		TreeNode findClosestTo = getNode(root, input);
		int level = 1;
		if (findClosestTo.sibling != null) {
			System.out.println("Closest peer node: " + findClosestTo.sibling.data);
			return;
		}
		if (findClosestTo == root) {
			System.out.println("No closest peer node exist");
			return;
		}
		findNeighbourNode(findClosestTo.parent, level);
	}

	private void findNeighbourNode(TreeNode node, int level) {
		if (level == 0) {
			System.out.println("Closest peer node: " + node.data);
			System.exit(0);
		}
		// if sibling link then check sibling child
		if (node.sibling != null) {
			flag = true; // to avoid infinite loop
			if (node.sibling.child != null) {// checking first sibling's child
				level--; // while checking child decreasing level
				findNeighbourNode(node.sibling.child, level);
			} else
				findNeighbourNode(node.sibling, level);
		}
		if (node.child != null && flag) {
			level--;
			findNeighbourNode(node.child, level);
		}
		if (node.parent != null) {
			flag = false;
			level++; // while backtracking i'm adding level
			findNeighbourNode(node.parent, level);
		}
		System.out.println("No closest peer node exist");
		System.exit(0);
	}

	// printing tree -> sibling-child
	public void print(TreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			if (root.sibling != null)
				print(root.sibling);
			print(root.child);
		}
	}

	public static void main(String[] args) {
		TreeClosestPeer tp = new TreeClosestPeer();
		tp.insert("A", true);
		tp.insert("B", true);
		tp.insert("C", true);
		tp.insert("D", true);
		tp.insert("E", false);

		tp.addSibling("C", "F"); // method for adding siblings
		tp.insert("F", true);
		tp.insert("G", false);
		tp.addSibling("B", "H");
		tp.insert("H", true);
		tp.insert("I", false);

		tp.addSibling("I", "J");
		tp.insert("J", true);
		tp.insert("K", false);

		tp.addSibling("H", "L");
		tp.insert("L", true);
		tp.insert("M", true);
		tp.insert("N", true);
		tp.insert("O", false);
		// add remaining parent link
		tp.addParentLink("H", "A");
		tp.addParentLink("L", "A");
		tp.addParentLink("J", "H");
		tp.addParentLink("F", "B");
		
		// print tree
		// tp.print(tp.root);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter node: ");
		String input = sc.next();
		// method to find closest node
		tp.getClosestPeer(input);


	}

}
