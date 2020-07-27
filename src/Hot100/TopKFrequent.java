package Hot100;

import java.util.*;

public class TopKFrequent {
    static Comparator<int []> cmp = new Comparator<int []>() {
        public int compare(int[] e1, int[] e2) {
            return e2[1] - e1[1];
        }
    };
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        PriorityQueue<int []> priorityQueue=new PriorityQueue<>(cmp);
        for (int num:nums) hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        Iterator<Map.Entry<Integer, Integer>> entries = hashMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            int [] temp=new int[2];
            temp[0]=entry.getKey() ;
            temp[1]=entry.getValue();
            priorityQueue.add(temp);
        }
        int [] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=priorityQueue.poll()[0];
        }
        return res;
        }
}
