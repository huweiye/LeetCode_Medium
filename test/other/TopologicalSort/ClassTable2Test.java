package other.TopologicalSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassTable2Test {
    @Test
    public void findOrder() throws Exception {
        ClassTable2 c=new ClassTable2();
        c.findOrder(2,
                new int[][]{{1,0}});
    }

}