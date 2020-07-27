package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayTest {
    @Test
    public void maxSubArray() throws Exception {
        MaxSubArray m=new MaxSubArray();
        System.out.println(m.maxSubArray(new int []{-2,-1,-2}));
    }

}