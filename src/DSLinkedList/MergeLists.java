package DSLinkedList;

// { Driver Code Starts
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class MergeLists {
	Node head;

	/* Function to print linked list */
	public static void printList(Node head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
			Node tail1 = head1;
			for (int i = 0; i < n1 - 1; i++) {
				tail1.next = new Node(sc.nextInt());
				tail1 = tail1.next;
			}
			Node head2 = new Node(sc.nextInt());
			Node tail2 = head2;
			for (int i = 0; i < n2 - 1; i++) {
				tail2.next = new Node(sc.nextInt());
				tail2 = tail2.next;
			}

			LinkedList obj = new LinkedList();

			printList(head1);
			printList(head2);
			Node head = obj.sortedMerge(head1, head2);
			printList(head);

			t--;

		}

		sc.close();
	}
}
// } Driver Code Ends

/*
 * Merge two linked lists head pointer input could be NULL as well for empty
 * list Node is defined as class Node { int data; Node next; Node(int d) {data =
 * d; next = null; } }
 */

class LinkedList {
	// Function to merge two sorted linked list.
	Node sortedMerge(Node head1, Node head2) {
		// This is a "method-only" submission.
		// You only need to complete this method

		Node init = head1, prev = null;
		Node head2count = head2;
		while (head1 != null || head2 != null) {
			if (head1.data <= head2.data) {
				prev = head1;
				if (head1.next != null) {
					head1 = head1.next;
					// System.out.println("data1:" + head1.data + " " + head2.data);
				} else {
					break;
				}
			} else {
				Node temp = new Node(head2.data);

				if (prev != null) {
					temp.next = prev.next;
					prev.next = temp;
					prev = prev.next;
				} else {
					temp.next = head1;
					prev = temp;
					head1 = temp;
					init = temp;
				}

				if (head2.next != null) {
					head2 = head2.next;
					head2count = head2;
				} else {
					break;
				}

				/*
				 * System.out.println("data3:" + head1.data + " " + head2.data + " " + prev.data
				 * + " " + temp.data); System.out.println("Print head1");
				 * MergeLists.printList(head1);
				 */
			}
		}

		while (head2count != null && head1.data <= head2count.data) {
			// System.out.println("data2:" + head1.data + " " + head2count.data);
			Node temp = new Node(head2count.data);
			head1.next = temp;
			head1 = head1.next;
			// System.out.println("data5:" + head1.data + " " + head2count.data);
			// MergeLists.printList(head1);
			head2count = head2count.next;
		}

		head1 = init;

		return head1;
	}
}
