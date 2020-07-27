package SlidingWindowANDDoublePointer;

public class RemoveNthFromEnd {
    public RemoveNthFromEnd() {
        super();
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

         /*快慢指针，让快指针先走 k 步，然后快慢指针开始同速前进。
        这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点
        * */
        ListNode fast=new ListNode(-1);
        fast.next=head;
        ListNode slow=fast;
        ListNode pre_h=fast;

        while (n>0){
            fast=fast.next;
            n--;
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        //此时slow.next指向倒数第n个节点,slow指向倒数第n-1个节点，1<=n<=链表长度
        slow.next=slow.next.next;
        return pre_h.next;
    }
}
