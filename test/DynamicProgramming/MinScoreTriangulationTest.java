package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinScoreTriangulationTest {
    @Test
    public void minScoreTriangulation() throws Exception {
        MinScoreTriangulation m=new MinScoreTriangulation();
        System.out.println(m.minScoreTriangulation(new int[]{3,7,4,5}));
    }

}