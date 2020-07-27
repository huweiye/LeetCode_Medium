package Design;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopVotedCandidate {
    int [] persons;
    int [] times;
    int [] util_persons;//记录每一个当前下标时，出现次数最多的person
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons=persons;
        this.times=times;
        util_persons=new int[persons.length];
        util();
    }
    private void util(){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int max_per=persons[0];
        int max_q=1;
        util_persons[0]=max_per;
        for(int i=0;i<util_persons.length;i++){
            hashMap.put(persons[i],hashMap.getOrDefault(persons[i],0)+1);
            if(hashMap.get(persons[i])>=max_q){
                max_per=persons[i];
                max_q=hashMap.get(persons[i]);
            }
            util_persons[i]=max_per;
        }
    }

    public int q(int t) {
        return util_persons[binarydivide(t)];
    }

    private int binarydivide(int target){//二分查找小于等于target的最大元素（右边界）
        int left=0;
        int right=times.length-1;
        int mid=-1;
        int res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(times[mid]<=target){//满足条件，缩小到右半区间去查找
                left=mid+1;
                res=mid;
            }else{
                right=mid-1;
            }
        }
        return res;//TopVotedCandidate.q(int t) 被调用时总是满足 t >= times[0]
    }
}
