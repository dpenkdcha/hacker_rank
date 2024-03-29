package DSLinkedList;

import java.util.*;
import java.io.*;


public class ReverseList{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head); 
            t--;
        }
        
        sc.close();
    } 
} 


class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        
        Node prev = null;
        Node cur = head;
        Node next = null;
        
        while(cur != null) {
        	next = cur.next;
        	cur.next = prev;
        	prev = cur; 
            cur = next;
        }
        head = prev;
        
        return head;
    }
}
