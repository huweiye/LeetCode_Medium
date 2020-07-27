package SlidingWindowANDDoublePointer;

public class DetectCycle2 {
    public DetectCycle2() {
        super();
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        //先检测链表是否有环
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) break;
        }
        if(fast==null||fast.next==null) return null;

        //再从头开始同速前进，直到相遇
        slow=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;


    }
}
