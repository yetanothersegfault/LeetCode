import java.util.List;

public class MergeTwoLists {
	
	public static void main(String[] args)
	{
		//make two lists
		//List 1
		ListNode l1 = new ListNode();
		ListNode temp = l1;
		temp.val = 1;
		ListNode newNode = new ListNode();
		temp.next = newNode;
		temp = temp.next;
		temp.val = 2;
		newNode = new ListNode();
		temp.next = newNode;
		temp = temp.next;
		temp.val = 4;
		
		//List 2
		ListNode l2 = new ListNode();
		temp = l2;
		temp.val = 1;
		newNode = new ListNode();
		temp.next = newNode;
		temp = temp.next;
		temp.val = 3;
		newNode = new ListNode();
		temp.next = newNode;
		temp = temp.next;
		temp.val = 4;
		
		MergeTwoLists merge = new MergeTwoLists();
		ListNode solution = merge.mergeTwoLists(l1, l2);
		
	}
	
	//Assumes that both incoming lists are already sorted.
	//
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode returnList = new ListNode();
		ListNode temp = returnList;
		while(l1 != null && l2 != null)
		{
			//l1 has the lower or equal value
			if(l1.val <= l2.val)
			{
				//create new node for the node
				ListNode newNode = new ListNode();
				newNode.val = l1.val;
				//move pointers
				temp.next = newNode;
				l1 = l1.next;
			}
			else //l2 has the lower value
			{
				//create new node for the node
				ListNode newNode = new ListNode();
				newNode.val = l2.val;
				//move pointers
				temp.next = newNode;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		
		//reached the end of one list, figure out which list we have reached the end off (ie which pointer is now null)
		//if l1 is null then we need to add the rest of l2
		if(l1 == null)
		{
			temp.next = l2;
		}
		else
		{
			//reaching here means that l2 was null
			//add the rest of l1
			temp.next = l1;
		}
		
		//move the pointer on returnList one to keep in line with the expected answer
		returnList = returnList.next;
		
		return returnList;
	}
}
