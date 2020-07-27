package Hot100;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateTest {
    @Test
    public void rotate() throws Exception {
        Rotate rotate=new Rotate();
        rotate.rotate(new int[][]{{1,2,3},
  {4,5,6},
  {7,8,9}});
    }

}