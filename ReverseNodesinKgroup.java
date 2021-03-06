class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Save the previous reversed pointer in prev and in wach iteration use prev.next to set the previous ptr to the current reversed.
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode tempHead = head;
        ListNode prev = tempNode;
        while(tempHead!=null){
            // Starting of each reversed list, it will become the last after reversing
            ListNode klast = tempHead;
            int num = k;
            // Jump k 
            while(num>0 && tempHead!=null){
                tempHead = tempHead.next;
                num--;
            }
            // If cannot reverse
            if(num!=0) {
                prev.next = klast;
                break;
            }
            // start of each reversed group
            ListNode kstart = reverse(klast,k);
            
            // Use previous's next to point to curr reversed
            prev.next = kstart;
            // Set prev to current rev end.
            prev = klast; 
        }
        return tempNode.next;
        
    }
    
    // Standard reverse code
    public ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        while(head!=null && k>0){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            k--;
        }
        return prev;
    }
    
}