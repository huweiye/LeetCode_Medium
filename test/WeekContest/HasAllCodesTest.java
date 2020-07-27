package WeekContest;

import WeekContest.past.HasAllCodes;
import org.junit.Test;

public class HasAllCodesTest {
    @Test
    public void hasAllCodes() throws Exception {
        HasAllCodes h=new HasAllCodes();
        System.out.println(h.hasAllCodes("0110",
                2));
    }

}