package WeekContest.num197;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxProbabilityTest {
    @Test
    public void maxProbability() throws Exception {
        MaxProbability maxProbability=new MaxProbability();
        maxProbability.maxProbability(3,new int[][]{{0,1},{1,2},{0,2}},new double[]{0.5,0.5,0.2},0,2);
    }

}