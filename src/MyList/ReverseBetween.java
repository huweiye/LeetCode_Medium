package MyList;

public class ReverseBetween {
    /*反转m~n之间的一段链表
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==1) return reverseFront(head,n);
        m--;
        n--;
        head.next=reverseBetween(head.next,m,n);
        return head;
    }

    public ListNode reverseFront(ListNode head,int n) {//迭代实现
        if(head==null) return null;
        int i=1;//链表的节点从1开始计数
        ListNode pre=null,curr=head;
        ListNode next;
        ListNode new_last=head;
        while (curr!=null&&i<=n){//当前节点应该反转
            //之字形
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
            i++;
        }
        //题目满足n<= 链表长度，所以一定是因为i>n退出的
        new_last.next=curr;
        return pre;
    }
}
