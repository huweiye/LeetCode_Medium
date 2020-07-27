package BinaryDivide;

import org.junit.Test;

import static org.junit.Assert.*;

public class HIndexTest {
    @Test
    public void hIndex() throws Exception {
        HIndex h=new HIndex();
        h.hIndex(new int[]{7,7,7,7,7,7,7});
    }

    @Test
    public void is_a_Hindex() throws Exception {
    }

}