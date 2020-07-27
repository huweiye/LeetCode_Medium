package BFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDistanceTest {
    @Test
    public void maxDistance() throws Exception {
        MaxDistance maxDistance=new MaxDistance();
        System.out.println(maxDistance.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }

}