package SlidingWindowANDDoublePointer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    Deque<Integer> deque = new LinkedList<>();
    int [] nums;
    public void offer_last(int i){
        while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
            deque.pollLast();
        }
        deque.offerLast(i);
    }
    public int get_top(int left){
        while (!deque.isEmpty()&&deque.peekFirst()<left){//下标不符合
            deque.pollFirst();
        }
        return deque.peekFirst();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums=nums;
        int n=nums.length;
        int [] res=new int[n-k+1];
        for(int i=0;i<k-1;i++) offer_last(i);//先把前k-1个入单调队列

        for(int i=k-1;i<n;i++){
            offer_last(i);
            res[i-(k-1)]=nums[get_top(i-(k-1))];
        }
        return res;

    }
}
