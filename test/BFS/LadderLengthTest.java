package BFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LadderLengthTest {
    @Test
    public void ladderLength() throws Exception {
        LadderLength ladderLength=new LadderLength();
        List<String> x=new ArrayList<>();
        String[] xx=new String[]{"hot","dot","dog","lot","log","cog"};
        x= Arrays.asList(xx);
        System.out.println(ladderLength.ladderLength("hit","cog",x));
    }

}