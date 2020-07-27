package WeekContest.num196;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumSubmatTest {
    @Test
    public void numSubmat() throws Exception {
        NumSubmat numSubmat=new NumSubmat();
        System.out.println(numSubmat.numSubmat(new int[][]{{1,0,1},
            {1,1,0},
            {1,1,0}}));

    }

}