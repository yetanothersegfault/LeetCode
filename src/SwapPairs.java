public class SwapPairs {
	public static void main(String[] args)
	{
		//Form List
		ListNode head = new ListNode();
//		ListNode temp = head;
//		temp.val = 1;
//		ListNode newNode = new ListNode();
//		temp.next = newNode;
//		temp = temp.next;
//		temp.val = 2;
//		newNode = new ListNode();
//		temp.next = newNode;
//		temp = temp.next;
//		temp.val = 3;
//		newNode = new ListNode();
//		temp.next = newNode;
//		temp = temp.next;
//		temp.val = 4;
//		newNode = new ListNode();
//		temp.next = newNode;
//		temp = temp.next;
//		temp.val = 5;

		SwapPairs solution = new SwapPairs();
		ListNode swapped = solution.swapPairs(head);
	}

	public ListNode swapPairs(ListNode head)
	{
		//set up nodes for swapping
		ListNode h1 = null;
		ListNode h2 = null;
		ListNode temp = null;
		//check to make sure we actually have nodes in list
		if(head != null)
		{
			h1 = head;
			h2 = head.next;
			temp = h1;
		}

		boolean isFirst = true;
		//keep going till end of list
		while(h1 != null && h2 != null)
		{
			//swap the pointers swap the pairs
			h1.next = h2.next;
			h2.next = h1;
			//first time is a special case because we need to reset the head pointer to the new start of the linked list
			if(isFirst)
			{
				head = h2;
				isFirst = false;
			}
			else
			{
				//temp is the previous h1
				//use this to link the existing list to the swapped list
				temp.next = h2;
			}
			//move pointers
			temp = h1;
			h1 = h1.next;
			if(h1 != null)
			{
				//we know that there is at least a null pointer after current h1
				h2 = h1.next;
			}
		}
		return head;
	}
}
