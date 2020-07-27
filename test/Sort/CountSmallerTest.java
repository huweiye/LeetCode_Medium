package Sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountSmallerTest {
    @Test
    public void countSmaller() throws Exception {
        CountSmaller countSmaller=new CountSmaller();
        countSmaller.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41});
    }

}