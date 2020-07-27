package BFS;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpenLockTest {
    @Test
    public void openLock() throws Exception {
        OpenLock openLock=new OpenLock();
        System.out.println(openLock.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
    }

}