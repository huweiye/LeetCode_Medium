package SlidingWindowANDDoublePointer;

import SlidingWindowANDDoublePointer.PartitionLabels;
import org.junit.Test;

public class PartitionLabelsTest {
    @Test
    public void partitionLabels() throws Exception {
        PartitionLabels partitionLabels=new PartitionLabels();
        partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
    }

}