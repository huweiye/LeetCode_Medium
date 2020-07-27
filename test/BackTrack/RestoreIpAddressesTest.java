package BackTrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestoreIpAddressesTest {
    @Test
    public void restoreIpAddresses() throws Exception {
        RestoreIpAddresses r=new RestoreIpAddresses();
        r.restoreIpAddresses("111111111111111111111111111111111111111111111");
    }

}