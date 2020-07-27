package BinaryDivide;

public class SmallestDivisor {
    public SmallestDivisor() {
        super();
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;//除数能取到的最小值
        int max_nums=nums[0];
        for(int i=0;i<nums.length;i++){
            max_nums=Math.max(nums[i],max_nums);
        }
        int right=max_nums;//除数有可能满足题意的最大值
        int mid=-1;int res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(helper(nums,mid,threshold)){right=mid-1;res=mid;}//满足条件，为了找左边界，继续向左半区间缩小
            else left=mid+1;//不满足条件，除数还不够大
        }
        return res;
    }
    public boolean helper(int [] nums,int mid,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]%mid==0) sum+=nums[i]/mid;
           else sum+=(nums[i]/mid+1);
        }
        return sum<=threshold;
    }

}
