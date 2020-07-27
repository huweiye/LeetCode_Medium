package WeekContest.num192;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrowserHistoryTest {
    @Test
    public void visit() throws Exception {
    }

    @Test
    public void back() throws Exception {
    }

    @Test
    public void forward() throws Exception {
    }
    @Test
    public void test1(){
        BrowserHistory b=new BrowserHistory("leetcode.com");
        b.visit("google.com");
        b.visit("facebook.com");
        b.visit("youtube.com");
        b.back(1);
        b.back(1);
        b.forward(1);
        b.visit("linkedin.com");
        b.forward(2);
        b.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        b.back(7);



    }

}