package DFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {
    @Test
    public void generateParenthesis() throws Exception {
        GenerateParenthesis g=new GenerateParenthesis();
        g.generateParenthesis(4);
        for (String s:g.dfs_str
             ) {
            System.out.print(s);
            System.out.println();
        }
    }

}