package MyList;

public class Reverse {
    /*反转整个单链表的迭代和递归实现
    例：1->2->null
    * */
    public ListNode reverseList(ListNode head) {//迭代实现
        ListNode pre=null,curr=head;
        ListNode next;
        while (curr!=null){//每次只处理一个节点的指向
            //指针的赋值顺序呈之字形
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }//1->2->null变成null<-1 2->null变成null<-1<-2
        return pre;

    }
    public ListNode reverseList2(ListNode head) {//递归实现
        if(head==null) return null;
        if(head.next==null) return head;//只有一个节点，不需要反转
        ListNode new_head=reverseList(head.next);//函数返回，以head.next为头的后面的链表都反转完了
        head.next.next=head;//head.next是已经反转好的链表的尾节点
        head.next=null;
        return new_head;
    }
}
