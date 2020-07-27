package WeekContest.past;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {
    public HasAllCodes() {
        super();
    }

    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        int x=(int)Math.pow(2.0,k);
        Set hs = new HashSet();
        for(int i=0;i<n-k+1;i++){
            int j=i+k-1;
            int temp=Integer.parseUnsignedInt(s.substring(i,j+1),2);
            if(temp<x){
                hs.add(temp);
            }
        }
        for(int i=0;i<x;i++) {
            if(!hs.contains(i)) return false;
        }
        return true;


    }

}
