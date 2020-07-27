package DynamicProgramming;

public class Rob1 {
    public Rob1() {
        super();
    }
    public int rob(int[] nums) {
        //不是简单的把奇数项元素加在一起与偶数项元素加在一起比较这俩大小就行的
        //如:[2,1,1,2]最大是2+2=4
        //方程:dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        if(nums.length==0){
            return 0;
        }
        int dp_i_2=0;
        int dp_i_1=0;
        int dp=nums[0];
        for(int i=1;i<nums.length;i++){
            dp_i_2=dp_i_1;
            dp_i_1=dp;

            if(dp_i_2+nums[i]>dp_i_1){
                dp=dp_i_2+nums[i];
            }else{
                dp=dp_i_1;
            }

        }
        return dp;



    }
}
