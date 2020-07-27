package DynamicProgramming;

import org.junit.Test;

public class MaxProfit1Test {
    @Test
    public void maxProfit() throws Exception {
        MaxProfit1 m=new MaxProfit1();
        int [] a={2,1,2,1,0,1,2};
        System.out.println(m.maxProfit(a));
    }

}