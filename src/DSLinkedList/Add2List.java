package DSLinkedList;

import java.util.*;

public class Add2List{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Node res = Solution1.addTwoLists(first, second);
            printList(res);
        }
        sc.close();
    }
}


class Solution1{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
		
    	Node prvFirst = null;
    	Node curFirst = first;
    	Node nxtFirst = null;
    	while(curFirst != null) {
    		nxtFirst = curFirst.next;
    		curFirst.next = prvFirst;
    		prvFirst = curFirst;
    		curFirst = nxtFirst;
    	}
    	
    	first = prvFirst;
    	
    	Node prvSecond = null;
    	Node curSecond = first;
    	Node nxtSecond = null;
    	while(curSecond != null) {
    		nxtSecond = curSecond.next;
    		curSecond.next = prvSecond;
    		prvSecond = curSecond;
    		curSecond = nxtSecond;
    	}
    	
    	second = prvSecond;
    	
    	Node finalSum = null;
    	int carry = 0;
    	while(first != null && second != null) {
			int x = 0;
			int y = 0;
			int sum = 0;
			if(first != null) {
				x = first.data;
			}
			if(second != null) {
				y = second.data;
			}
    		int nodeAdd = x + y + carry;
    		if(nodeAdd > 9) {
    			sum = nodeAdd % 10 ;
    			carry = nodeAdd / 10;
    		}
    		sum = nodeAdd;
    		
    		//System.out.println("sum" + sum);
    		
    		Node temp = new Node(sum);
    		if(finalSum == null) {
    			finalSum = temp;
    		} else {
    			temp.next = finalSum;
    			finalSum = temp;
    		}
    		
    	}
    	
    	if (carry != 0) {
	        Node temp = new Node(carry);
	        temp.next = finalSum;
	        finalSum = temp;
	    }
    	
    	return finalSum;
        
        
        
        
        
    }
}