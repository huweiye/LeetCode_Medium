package SlidingWindowANDDoublePointer;

import SlidingWindowANDDoublePointer.DetectCycle;
import SlidingWindowANDDoublePointer.ListNode;
import org.junit.Test;

public class DetectCycleTest {
    @Test
    public void detectCycle() throws Exception {
        ListNode l1=new ListNode(3);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(0);
        l1.next.next.next=new ListNode(-4);
        l1.next.next.next.next=l1.next;
        DetectCycle d=new DetectCycle();
        d.detectCycle(l1);
    }

}