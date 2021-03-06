package DynamicProgramming;

public class Rob2 {
    public Rob2() {
        super();
    }
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        //length>=2
        int dp_i_2=0;
        int dp_i_1=0;
        int dp_max1=nums[0];
        int dp_max2=nums[1];


        for(int i=1;i<nums.length-1;i++){
            dp_i_2=dp_i_1;
            dp_i_1=dp_max1;
            if(dp_i_2+nums[i]>dp_i_1){
                dp_max1=dp_i_2+nums[i];

            }else{
                dp_max1=dp_i_1;
            }
        }

        dp_i_1=0;
        dp_i_2=0;
        for(int i=2;i<nums.length;i++){
            dp_i_2=dp_i_1;
            dp_i_1=dp_max2;
            if(dp_i_2+nums[i]>dp_i_1){
                dp_max2=dp_i_2+nums[i];

            }else{
                dp_max2=dp_i_1;
            }
        }




        return Math.max(dp_max1,dp_max2);
    }
}
