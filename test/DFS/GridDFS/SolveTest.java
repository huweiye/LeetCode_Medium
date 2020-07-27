package DFS.GridDFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolveTest {
    @Test
    public void solve() throws Exception {
        Solve solve=new Solve();
        solve.solve(new char[][]{{'O','X','O'},{'X','O','X'},{'O','X','O'}});
    }

}