package MyList;

public class ReverseFront {
    /*反转从头节点开始，前面的n个节点组成的链表
    * */
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
    ListNode successor = null; // 后驱节点
    public ListNode reverseFront2(ListNode head,int n) {//递归实现
        if(n==1){//反转前1个节点，不用反转
            successor=head.next;
            return head;//返回反转完成后的头节点
        }
        ListNode new_head=reverseFront2(head.next,n-1);
        head.next.next=head;
        head.next=successor;
        return new_head;
    }

}
