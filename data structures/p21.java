import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class p21 {
    Node head;
    
    public p21() {
        this.head = null;
    }
    
    public void addLast(int data)
    {
    	Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
        
    public void add(int data, int pos) {
        Node newNode = new Node(data);
        if(pos == 0)
        {
        	newNode.next = head;
        	head = newNode;
        	return;
        }
       
        Node current = head;
        for(int i=1; i<pos; i++)
        {
        	if(current==null)
        	{
        		System.out.println("position exceeds");
        		return;
        	}
        	current = current.next;
        }
        if(current!=null)
        {
		newNode.next = current.next;
		current.next = newNode;
	}
	else
	{
		System.out.println("position exceeds");
        }
}
        		
    
    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    
    public static void main(String args[]) {
        int data, pos, n;
        Scanner input = new Scanner(System.in);
        p21 list = new p21();
        
        System.out.print("Enter number of elements to enter at last: ");
        n = input.nextInt();
        System.out.println("Enter data: ");
        for (int i = 0; i < n; i++) {
            data = input.nextInt();
            list.addLast(data);
        }
        System.out.println("List after addition at last: ");
        list.display();
        
        System.out.print("Enter position of to insert: ");
        pos = input.nextInt();
        System.out.println("Enter data: ");
        data = input.nextInt();
        list.add(data, pos);
        System.out.println("List after addition at anywhere: ");
        list.display();
        
        
        
        
        input.close(); // Closing scanner
    }
}

