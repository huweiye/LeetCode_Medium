import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void binary_search() throws Exception {
        BinarySearch b=new BinarySearch();
        int [] a={1,2,3,3,4,5,6,7,8,8,10};
        System.out.println(b.binary_search(a,0,a.length-1,10));
    }

}