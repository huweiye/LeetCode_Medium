package DFS.GridDFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumEnclavesTest {
    @Test
    public void numEnclaves() throws Exception {
        NumEnclaves n=new NumEnclaves();
        n.numEnclaves(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}});
    }

}