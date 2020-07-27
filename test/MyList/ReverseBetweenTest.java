package MyList;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseBetweenTest {
    @Test
    public void reverseBetween() throws Exception {
        ReverseBetween reverseBetween=new ReverseBetween();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        reverseBetween.reverseBetween(head,2,4);
    }

}