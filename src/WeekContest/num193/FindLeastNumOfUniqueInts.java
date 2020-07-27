package WeekContest.num193;

import java.util.*;

public class FindLeastNumOfUniqueInts {
    public FindLeastNumOfUniqueInts() {
        super();
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int a:arr) {
            hashMap.put(a,hashMap.getOrDefault(a,0)+1);
        }
        PriorityQueue<Arr_Count> queue = new PriorityQueue<Arr_Count>(
                new Comparator<Arr_Count>() {
                    public int compare(Arr_Count p1, Arr_Count p2) {
                        return p1.counter - p2.counter;
                    }
                });
        Iterator<Map.Entry<Integer, Integer>> entries = hashMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            queue.add(new Arr_Count(entry.getKey(),entry.getValue()));
        }
        while(k>0&&!queue.isEmpty()) {
            if(k>=queue.peek().counter){
                k-=queue.poll().counter;
            }else{
                break;
            }
        }
        return queue.size();
    }


    public class Arr_Count{
        public int a;
        public int counter;
        public Arr_Count(int a,int counter){
            this.a=a;
            this.counter=counter;
        }
    }

}
