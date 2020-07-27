package SlidingWindowANDDoublePointer;

public class MinSubArrayLen {
    public MinSubArrayLen() {
        super();
    }
    public int minSubArrayLen(int s, int[] nums) {//滑动窗口
        int n=nums.length;
        if(n==0) return 0;
        int left=0,right=0;
        int min_len=0;
        int sum_left_to_right=0;
        while(right<n){
            sum_left_to_right+=nums[right];
            if(sum_left_to_right>=s){
                if(min_len==0) min_len=right-left+1;//从无到有
                else min_len=Math.min(min_len,right-left+1);//两个满足条件的子数组才能比较大小
                sum_left_to_right-=nums[left];
                sum_left_to_right-=nums[right];
                left+=1;//每找到一个子数组，则重置窗口左边界left
            }else{
                right+=1;
            }
            if(left==right) break;//left一直增加，right却不增加，以至于left>right，只有一种可能，即nums存在一个元素>=s,当right指向该元素时，left会一直增加直到超过right

        }
        return min_len;


    }
}
