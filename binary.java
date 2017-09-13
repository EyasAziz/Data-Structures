import java.io.*;
public class binary 
{
	Node root;
	public void addNode(int key, String name)
	{
		if(root == null)
		{
			root = new Node(key,name);
		}
		else 
		{
			Node focusNode = root;
			Node parent;
			while(true)
			{
				parent = focusNode;
				if(key < focusNode.key)
				{
					focusNode = focusNode.leftChild;
					if(focusNode == null)
					{
						parent.leftChild = new Node(key, name);
						return;
					}
				}
				else
				{
					focusNode = focusNode.rightChild;
					if(focusNode == null)
					{
						parent.rightChild = new Node(key, name);
						return;
					}
				}
			}
		}
	}
	public void inorderTraversal(Node focusNode)
	{
		if(focusNode != null)
		{
			inorderTraversal(focusNode.leftChild);
			System.out.println(focusNode);
			inorderTraversal(focusNode.rightChild);
		}
	}
	public void preorderTraversal(Node focusNode)
	{
		if(focusNode != null)
		{
			System.out.println(focusNode);
			inorderTraversal(focusNode.leftChild);
			inorderTraversal(focusNode.rightChild);
		}
	}
	public void postorderTraversal(Node focusNode)
	{
		if(focusNode != null)
		{
			inorderTraversal(focusNode.leftChild);
			inorderTraversal(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	public boolean findNode(int key)
	{
		boolean flag = false;
		Node focusNode = root;
		while(focusNode != null)
		{
			if(focusNode.key == key)
			{
				 flag = true;
				 return flag;
			}
			else if(key < focusNode.key)
			{	
				focusNode = focusNode.leftChild;
			}
			else
			{	
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null)
			{
				flag = false;
			}
		}
		return flag;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		binary bt = new binary();
		bt.addNode(50,"Shayan");
		bt.addNode(75,"Parth");
		bt.addNode(32,"Sunny");
		bt.addNode(62,"Riaz");
		bt.addNode(48,"Mihir");
		bt.addNode(85,"Saurabh");
		bt.addNode(13,"Mukul");
		bt.addNode(78,"Harshit");
		bt.addNode(21,"Maroof");
		System.out.println("Inorder Traversal:");
		bt.inorderTraversal(bt.root);
		System.out.println();
		System.out.println("Preorder Traversal:");
		bt.preorderTraversal(bt.root);
		System.out.println();
		System.out.println("Postorder Traversal:");
		bt.postorderTraversal(bt.root);
		System.out.println();	
		System.out.print("Enter the key to be found: ");
		int key = Integer.parseInt(in.readLine());
		boolean flag = bt.findNode(key);
		if(flag == true)
		{
			System.out.println("Key Found!");
		}
		else
		{
			System.out.println("Key not Found!");
		}
	}
}

class Node
{
	int key;
	String name;
	Node leftChild;
	Node rightChild;
	Node(int key, String name)
	{
		this.key = key;
		this.name = name;
	}
	public String toString() 
	{
		return name + " has the key " + key;
	}
}