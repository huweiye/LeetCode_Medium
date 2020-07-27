package WeekContest.past;

import java.util.Arrays;
import java.util.HashMap;

public class CanBeEqual {
    public CanBeEqual() {
        super();
    }
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        for (int tar:target) {
            hashmap.put(tar,hashmap.getOrDefault(tar,0)+1);
        }
        for (int a:arr) {
            if(hashmap.get(a)==null) return false;
            else if(hashmap.get(a)==0) return false;
            else{
                hashmap.put(a,hashmap.get(a)-1);
            }
        }
        return true;

    }
}
