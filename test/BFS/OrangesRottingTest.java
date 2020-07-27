package BFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrangesRottingTest {
    @Test
    public void orangesRotting() throws Exception {
        OrangesRotting orangesRotting=new OrangesRotting();
        orangesRotting.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }

}