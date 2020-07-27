package DFS.GridDFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class PondSizesTest {
    @Test
    public void pondSizes() throws Exception {
        PondSizes p=new PondSizes();
        p.pondSizes(new int[][]{{0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}});
    }

}