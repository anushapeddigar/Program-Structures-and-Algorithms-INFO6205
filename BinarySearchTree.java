/*
 * Anusha Peddigari
 * 001023769
 */

package Test;

/**
 *
 * @author 16175
 */
public class BinarySearchTree {
Node root;
static final int COUNT = 10;  
	
	public static class Node {
		int key;
		Node left, right;
		
		Node() {
			this.key = 0;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node insert(Node node) {
		if(this.root == null) {
			return this.root = node;
		}		
		Node temp_node = this.root;
		while(temp_node != null) {
			if(node.key < temp_node.key) {
				if(temp_node.left == null) {
					temp_node.left = node;
					temp_node = node.left;
				} else {
					temp_node = temp_node.left;
				}
			} else if (node.key > temp_node.key) {
				if(temp_node.right == null) {
					temp_node.right = node;
					temp_node = node.right;
				} else {
					temp_node = temp_node.right;
				}
			}
		}
		return temp_node;
	}
	
	public boolean search(int val) {
		Node temp_node = this.root;
		boolean flag = false;
		while(temp_node != null) {
			if(val > temp_node.key) {
				temp_node = temp_node.right;
			} else if(val < temp_node.key) {
				temp_node = temp_node.left;
			} else if(val == temp_node.key) {
				flag = true;
				temp_node = null;
			}
		}
		return flag;
	}
	
	
	public Node searchMin(Node node) {
		if(node.left == null) {
			return node;
		}
		return searchMin(node.left);
	}
	
	public Node searchMax(Node node) {
		if(node.right == null) {
			return node;
		}
		return searchMax(node.right);
	}
	
	public Node deleteMin(Node root) {
		if(root == null) {
			return root;
		}		
		return delete(root, searchMin(root).key);
	}
	
	public Node deleteMax(Node root) {
		if(root == null) {
			return root;
		}
		return delete(root, searchMax(root).key);
	}
	
	public Node delete(Node root, int key) {
		if(root == null) {
			return root;
		}
		if(key < root.key) {
			root.left = delete(root.left, key);
		}
		else if(key > root.key) {
			root.right = delete(root.right, key);
		}
		else 
		{
			if(root.left == null) {
				Node temp = root.right;
				return temp;
			}
			else if (root.right == null) {
				Node temp = root.left;
				return temp;
			}
			else {
				Node temp = searchMin(root.right);
				root.key = temp.key;
				delete(root.right, temp.key);
			}
		}
		return root;
	}
static void print2DUtil(Node root, int space)  
{  
    // Base case  
    if (root == null)  
        return;  
  
    // Increase distance between levels  
    space += COUNT;  
  
    // Process right child first  
    print2DUtil(root.right, space);  
  
    // Print current node after space  
    // count  
    System.out.print("\n");  
    for (int i = COUNT; i < space; i++)  
        System.out.print(" ");  
    System.out.print(root.key + "\n");  
  
    // Process left child  
    print2DUtil(root.left, space);  
}  
  
// Wrapper over print2DUtil()  
static void print2D(Node root)  
{  
    // Pass initial space count as 0  
    print2DUtil(root, 0);  
}  
	public static void main(String[] args) {
		int[] array = {9,23,45,1,5,14,55,24,13,11,8,19,4,31,35,56};
		System.out.println("----");
		BinarySearchTree tree = new BinarySearchTree();
		Node root = new Node();
		for (int i : array) {
			Node node = new Node();
			node.key = i;
			tree.insert(node);
                        if(i==9)
                        { 
                        root = node;
                        }
		}
		print2D(root);  
	}

}
