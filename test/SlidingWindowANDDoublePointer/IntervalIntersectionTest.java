package SlidingWindowANDDoublePointer;

import SlidingWindowANDDoublePointer.IntervalIntersection;
import org.junit.Test;

public class IntervalIntersectionTest {
    @Test
    public void intervalIntersection() throws Exception {
        IntervalIntersection i=new IntervalIntersection();
        i.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24},{25,26}});
    }

}