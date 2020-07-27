package DynamicProgramming;

public class MaxSubArray {
    public MaxSubArray() {
        super();
    }
    public int maxSubArray(int[] nums) {
        int sum=nums[0],b=nums[0];
        for(int j=1;j<nums.length;j++){
            if(b>0) b+=nums[j];
            else b=nums[j];
            if(b>sum) sum=b;
        }
        return sum;
    }
}
