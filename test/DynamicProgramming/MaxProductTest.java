package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProductTest {
    @Test
    public void maxProduct() throws Exception {
        MaxProduct m=new MaxProduct();
        System.out.println(m.maxProduct(new int []{-2,3,-4}));
    }

}