package SlidingWindowANDDoublePointer;

public class DetectCycle {
    public DetectCycle() {
        super();
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            //如果含有环，快指针最终会超慢指针一圈，和慢指针相遇
            if(fast==slow) break;//快指针比慢指针多走了刚好一圈
        }
        if(fast==null||fast.next==null) return null;
        //把快慢指针中的任一个重新指向 head，然后两个指针同速前进，相遇之处就是环的起点了
        slow=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }




}
