package SlidingWindowANDDoublePointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public PartitionLabels() {
        super();
    }
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int n=S.length();
        for(int i=0;i<n;i++){
            hashMap.put(S.charAt(i),i);
        }
        ArrayList<Integer> res=new ArrayList<>();
        int left=0;
        for(int i=0,j=0;i<n;i++){
            j=Math.max(j,hashMap.get(S.charAt(i)));
            if(i==j){
                res.add(j-left+1);
                left=i+1;
            }
        }
        return res;

    }
}
