package Hot100;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindKthLargestTest {
    @Test
    public void findKthLargest() throws Exception {
        FindKthLargest findKthLargest=new FindKthLargest();
        findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }

}