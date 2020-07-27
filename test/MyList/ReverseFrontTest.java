package MyList;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseFrontTest {
    @Test
    public void reverseBetween() throws Exception {
        ReverseFront reverseFront=new ReverseFront();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        reverseFront.reverseFront2(head,3);
    }

}