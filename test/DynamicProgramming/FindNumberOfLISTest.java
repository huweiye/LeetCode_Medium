package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNumberOfLISTest {
    @Test
    public void findNumberOfLIS() throws Exception {
        FindNumberOfLIS f=new FindNumberOfLIS();
        System.out.println(f.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,8}));
    }

}