package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindLengthTest {
    @Test
    public void findLength() throws Exception {
        FindLength f=new FindLength();
        System.out.println(f.findLength(new int[]{1,0,0,0,1},new int[]{1,0,0,1,1}));
    }

}