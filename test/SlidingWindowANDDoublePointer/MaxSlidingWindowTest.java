package SlidingWindowANDDoublePointer;

import DynamicProgramming.MaxSubArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSlidingWindowTest {
    @Test
    public void maxSlidingWindow() throws Exception {
        MaxSlidingWindow maxSlidingWindow=new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

}