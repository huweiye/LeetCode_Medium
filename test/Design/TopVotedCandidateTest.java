package Design;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopVotedCandidateTest {
    @Test
    public void q() throws Exception {
        TopVotedCandidate topVotedCandidate=new TopVotedCandidate(new int[]{0,1,1,0,0,1,0},new int[]{0,5,10,15,20,25,30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));

    }

}