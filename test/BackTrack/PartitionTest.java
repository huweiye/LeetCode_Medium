package BackTrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionTest {
    @Test
    public void partition() throws Exception {
        Partition p=new Partition();
        p.partition("aab");
    }

}