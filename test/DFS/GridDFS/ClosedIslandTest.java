package DFS.GridDFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClosedIslandTest {
    @Test
    public void closedIsland() throws Exception {
        ClosedIsland closedIsland=new ClosedIsland();
        closedIsland.closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
    }

}