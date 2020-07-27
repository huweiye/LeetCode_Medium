package SlidingWindowANDDoublePointer;

import SlidingWindowANDDoublePointer.RemoveDuplicates;
import org.junit.Test;

public class RemoveDuplicatesTest {
    @Test
    public void removeDuplicates() throws Exception {
        RemoveDuplicates removeDuplicates=new RemoveDuplicates();
        removeDuplicates.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }

}