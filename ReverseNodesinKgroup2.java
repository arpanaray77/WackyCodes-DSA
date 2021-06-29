class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Java program to reverse a linked list in groups of given size k
	// Create a stack of Node*
	Stack<ListNode> mystack = new Stack<ListNode> ();
	ListNode current = head;
	ListNode prev = null;
    ListNode dummy=null;
    
	while (current != null)
	{
		// Terminate the loop whichever comes first
		// either current == NULL or count >= k
		int count = 0;
        dummy=current;
		while (current != null && count < k)
		{
			mystack.push(current);
			current = current.next;
			count++;
		}
        
        if(count<k)
        {
            while(dummy!=null)
            {
                prev.next=dummy;
                prev=prev.next;
                dummy=dummy.next;
            }
            break;
        }

		// Now pop the elements of stack one by one
		while (mystack.size() > 0)
		{

			// If first sublist is reversed
			if (prev == null)
			{
				prev = mystack.peek();
				head = prev;
				mystack.pop();
			}
			else
			{
				prev.next = mystack.peek();
				prev = prev.next;
				mystack.pop();
			}
		}
	}

	// Next of last element will point to NULL.
   prev.next = null;
	return head;
}
}

