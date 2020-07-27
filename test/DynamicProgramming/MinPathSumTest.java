package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinPathSumTest {
    @Test
    public void minPathSum() throws Exception {
        MinPathSum m=new MinPathSum();
        int [][] a=new int[3][3];
        a[0][0]=1;
        a[0][1]=3;
        a[0][2]=1;
        a[1][0]=1;
        a[1][1]=5;
        a[1][2]=1;
        a[2][0]=4;
        a[2][1]=2;
        a[2][2]=1;
        m.minPathSum(a);
    }

}