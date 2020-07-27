package MyList;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteDuplicatesTest {
    @Test
    public void deleteDuplicates() throws Exception {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        DeleteDuplicates deleteDuplicates=new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(head);
    }

}