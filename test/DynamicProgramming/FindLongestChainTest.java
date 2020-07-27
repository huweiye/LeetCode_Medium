package DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindLongestChainTest {
    @Test
    public void findLongestChain() throws Exception {
        FindLongestChain f=new FindLongestChain();
        System.out.println(f.findLongestChain(new int[][]{{9,10},{9,10},{4,5},{-9,-3},{-9,1},{0,3},{6,10},{-5,-4},{-7,-6}}));
    }

}