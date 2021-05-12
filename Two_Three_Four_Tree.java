/*
 * Anusha Peddigari
 * 001023769
 */


package Test;



/**
 *
 * @author 16175
 */
public class Two_Three_Four_Tree {

	private Node root = new Node();

	public int find(double key) {
		Node curNode = root;
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1)
				return childNumber;
			else if (curNode.isLeaf())
				return -1;
			else
				curNode = getNextChild(curNode, key);
		}
	}

	public void insert(int dValue)

	{
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);

		while (true) {
			if (curNode.isFull()) {
				split(curNode);
				curNode = curNode.getParent();

				curNode = getNextChild(curNode, dValue);
			}

			else if (curNode.isLeaf())
				break;

			else
				curNode = getNextChild(curNode, dValue);
		}

		curNode.insertItem(tempItem);
		System.out.println("Inserted  " + dValue);
	}

	public void split(Node thisNode) {
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;

		itemC = thisNode.removeItem();
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);
		child3 = thisNode.disconnectChild(3);

		Node newRight = new Node();

		if (thisNode == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, thisNode);
		} else
			parent = thisNode.getParent();

		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();

		for (int j = n - 1; j > itemIndex; j--) {
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j + 1, temp);
		}

		parent.connectChild(itemIndex + 1, newRight);

		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}

	public Node getNextChild(Node theNode, double theValue) {

		int j;

		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) {
			if (theValue < theNode.getItem(j).dData)
				return theNode.getChild(j);
		} // end for
		return theNode.getChild(j);
	}

	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	
	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + " ");
		thisNode.displayNode();

		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) {
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null)
				recDisplayTree(nextNode, level + 1, j);
			else
				return;
		}
	}

	public static void main(String[] args) {
		Two_Three_Four_Tree tree = new Two_Three_Four_Tree();

		int[] array = {9,23,45,1,5,14,55,24,13,11,8,19,4,31,35,56};

		for (int i : array) {
			tree.insert(i);
		}
	}

}

class Node {
	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node childArray[] = new Node[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER - 1];

	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node getChild(int childNum) {
		return childArray[childNum];
	}

	public Node getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return numItems;
	}

	public DataItem getItem(int index) // get DataItem at index
	{
		return itemArray[index];
	}

	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}

	public int findItem(double key)

	{
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null)
				break;
			else if (itemArray[j].dData == key)
				return j;
		}
		return -1;
	}

	public int insertItem(DataItem newItem) {

		numItems++;
		double newKey = newItem.dData;

		for (int j = ORDER - 2; j >= 0; j--) {
			if (itemArray[j] == null)
				continue;
			else {
				double itsKey = itemArray[j].dData;
				if (newKey < itsKey)
					itemArray[j + 1] = itemArray[j];
				else {
					itemArray[j + 1] = newItem;
					return j + 1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}

	public DataItem removeItem() {
		DataItem temp = itemArray[numItems - 1];
		itemArray[numItems - 1] = null;
		numItems--;
		return temp;
	}

	public void displayNode() {
		for (int j = 0; j < numItems; j++)
			itemArray[j].displayItem();
		System.out.println("/");
	}

}

class DataItem {
	public double dData;

	public DataItem(double dd) {
		dData = dd;
	}

	public void displayItem() {
		System.out.print("/" + dData);
	}

}
