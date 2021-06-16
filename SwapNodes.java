/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null)
            return head;
        
        //usng a dummy to store head of list
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //a node for iterating through the linked list
        ListNode curr=dummy;
        
        while(curr.next!=null && curr.next.next!=null)
        {
    //use curr node to swap its next 2 nodes (i.e, curr->p1->p2) here p1 and p2 will be swapped
            ListNode p1=curr.next;
            ListNode p2=curr.next.next;
            
            //swapping pointers
             p1.next=p2.next;
            
            //after swapping we changed curr.next as p2 and curr.next.next as p2 (i.e curr->p2->p1)
             curr.next=p2;
            curr.next.next=p1;
            
            //moving curr node by two steps as we r swapping in pairs
            curr=curr.next.next;
              
        }
        return dummy.next;
    }
}