package MyList;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode left=head,right=head.next;
        ListNode pre=null;
        while (right!=null){
           if(left.val!=right.val){
               pre=left;
               left=right;
               right=right.next;
           }else{
               while (right!=null&&left.val==right.val) right=right.next;
               if(pre==null) head=right;
               else pre.next=right;
               if(right==null) break;
               left=right;
               right=right.next;
           }
        }
        return head;
    }
}
