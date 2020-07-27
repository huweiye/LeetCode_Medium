package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProfit_FreezeTest {
    @Test
    public void maxProfit() throws Exception {
        MaxProfit_Freeze m=new MaxProfit_Freeze();
        System.out.println(m.maxProfit(new int[]{1,2,0,5}));
    }

}