import java.io.*;

public class SingleLinkedList 
{
	Node head;
	Node current;
	int size;
	
	public void display()
	{
		size = 0;
		current = head;
		while(current != null)
		{
			System.out.print(current.data+" -> ");
			current = current.next;
			size++;
		}
		System.out.println("The size of the list is: "+size);
	}
	public void Insert(int d)
	{
		if(head == null)
		{
			head  = new Node(d);
			return;
		}
		Node last = new Node(d);
		current = head;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = last;
		System.out.println("Element added at the end");
	}
	public void InsertAtIndex(int i,int d)
	{
		Node middle = new Node(d);
		int tempindex = 0 ;
		current = head;
		if(i>size||i<0)
		{
			System.out.println("Invalid Index: ");
		}
		if(i==0)
		{
			middle.next = head;
			head = middle;
			System.out.println("Element added at the beginning:");
			return;
		}
		while(tempindex < i-1)
		{
			current = current.next;
			tempindex++;
		}
		middle.next = current.next;
		current.next = middle;
		System.out.println("Element added at index: "+i);
	}
	public void DeleteAtIndex(int i)
	{
		current = head;
		int tempindex = 0;
			if(i>size||i<0)
			{
				System.out.println("Invalid Index:");
			}
		if(i==0)
		{
			head = head.next;
			System.out.println("Element deleted successfuly at index: "+i);
			return;
		}
		while(tempindex < i-1)
		{
			tempindex++;
			current = current.next;
		}
		current.next = current.next.next;
		System.out.println("Element deleted successfuly at index: "+i);
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		SingleLinkedList sll = new SingleLinkedList();
		int ch,value,index;
		do
		{
			System.out.println("----MENU----");
			System.out.println("1. Insert");
			System.out.println("2. Insert At Index");
			System.out.println("3. Delete At Index");
			System.out.println("4. Display");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			ch = Integer.parseInt(in.readLine());
			switch(ch)
			{
			case 1:
				System.out.println("Enter value to be inserted: ");
				value = Integer.parseInt(in.readLine());
				sll.Insert(value);
				break;
			case 2:
				System.out.println("Enter value to be inserted: ");
				value = Integer.parseInt(in.readLine());
				System.out.println("Enter index of value to be inserted: ");
				index = Integer.parseInt(in.readLine());
				sll.InsertAtIndex(index, value);
				break;
			case 3:
				System.out.println("Enter index of value to be deleted: ");
				index = Integer.parseInt(in.readLine());
				sll.DeleteAtIndex(index);
				break;
			case 4:
				sll.display();
				break;
			case 5:
				System.out.println("---END OF PROGRAM---");
				break;
			default:
				System.out.println("Wrong Choice:");
			}
		}while(ch!=5);
	}
}

class Node
{
	Node next = null;
	int data;
	public Node(int d)
	{
		this.data = d;
	}
}