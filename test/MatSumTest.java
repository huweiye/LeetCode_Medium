import org.junit.Test;

import static org.junit.Assert.*;

public class MatSumTest {
    @Test
    public void get_squ() throws Exception {
        int [][] mat={{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        MatSum m=new MatSum(mat);
        System.out.println(m.get_squ(1,1,2,2));
    }

}