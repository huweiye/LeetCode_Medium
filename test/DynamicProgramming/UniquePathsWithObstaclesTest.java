package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsWithObstaclesTest {
    @Test
    public void uniquePathsWithObstacles() throws Exception {
        UniquePathsWithObstacles u=new UniquePathsWithObstacles();
        int [][] a=new int[4][5];
        a[0][0]=0;
        a[0][1]=1;
        a[0][2]=0;
        a[0][3]=0;
        a[0][4]=0;
        a[1][0]=1;
        a[1][1]=0;
        a[1][2]=0;
        a[1][3]=0;
        a[1][4]=0;
        a[2][0]=0;
        a[2][1]=0;
        a[2][2]=0;
        a[2][3]=0;
        a[2][4]=0;
        a[3][0]=0;
        a[3][1]=0;
        a[3][2]=0;
        a[3][3]=0;
        a[3][4]=0;
        System.out.println( u.uniquePathsWithObstacles(a));
    }

}