package SlidingWindowANDDoublePointer;

public class Partition {
    public Partition() {
        super();
    }
    public ListNode partition(ListNode head, int x) {
        ListNode pre=new ListNode(-1);//虚拟头节点
        pre.next=head;
        ListNode p=pre;//p.next指向链表中第一个大于等于x的节点
        while (p.next!=null&&p.next.val<x){
            p=p.next;
        }
        if(p.next==null) return head;
        ListNode q=p.next;
        ListNode the_x=p.next;//the_x始终指向第一个大于等于x的节点，也是后面所有待移动节点将要指向的节点
        while (q.next!=null){
            if(q.next.val<x){//q.next指向不满足排列要求的（即小于x但是排在p.next之后的）节点，需要进行移动
                p.next=q.next;
                q.next=q.next.next;
                p.next.next=the_x;
                p=p.next;
            }else{
                q=q.next;
            }
        }
        return pre.next;
    }
    public ListNode partition2(ListNode head, int x) {
        ListNode pre_head1=new ListNode(-1);//虚拟头节点1
        ListNode pre_head2=new ListNode(-1);//虚拟头节点2
        ListNode head1=pre_head1;
        ListNode head2=pre_head2;
        while (head!=null){
            if(head.val<x){
                head1.next=head;
                head1=head1.next;
            }
            else{
                head2.next=head;
                head2=head2.next;
            }
            head=head.next;
        }
        head2.next=null;
        head1.next=pre_head2.next;
        return pre_head1.next;


    }
}
