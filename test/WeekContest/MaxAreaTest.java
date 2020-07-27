package WeekContest;

import WeekContest.past.MaxArea;
import org.junit.Test;

public class MaxAreaTest {
    @Test
    public void maxArea() throws Exception {
        MaxArea m=new MaxArea();
        System.out.println(m.maxArea(50,
                15, new int[]{37,40,41,30,27,10,31},new int[]{2,1,9,5,4,12,6,13,11}));
    }

}
