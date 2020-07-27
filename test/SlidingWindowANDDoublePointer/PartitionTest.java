package SlidingWindowANDDoublePointer;

import SlidingWindowANDDoublePointer.ListNode;
import SlidingWindowANDDoublePointer.Partition;
import org.junit.Test;

public class PartitionTest {
    @Test
    public void partition2() throws Exception {
        Partition p=new Partition();
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        p.partition2(head,3);
    }

}