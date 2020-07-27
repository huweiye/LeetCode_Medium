package other.TopologicalSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassTableTest {
    @Test
    public void canFinish() throws Exception {
        ClassTable c=new ClassTable();
        c.canFinish(2,
                new int[][]{{1,0}});
    }

}