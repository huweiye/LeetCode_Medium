package WeekContest.num30;

import java.util.PriorityQueue;

public class RangeSum {

    public int rangeSum(int[] nums, int n, int left, int right) {
        int [] preix=new int[n+1];
        preix[0]=0;
        for(int i=1;i<=n;i++) preix[i]=preix[i-1]+nums[i-1];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int len=1;len<=n;len++){
            for(int i=1;i<=(n-len+1);i++){
                int j=(i+len-1);
                priorityQueue.add(preix[j]-preix[i-1]);
            }
        }

        int start=1;
        int end=left;
        long res=0L;
        while (start<left){priorityQueue.poll();start++;}
        while (end<=right){
            res=(long)priorityQueue.poll()+res;
            end++;
        }
        return (int)(res%(long)(1000000000+7));




    }
}
