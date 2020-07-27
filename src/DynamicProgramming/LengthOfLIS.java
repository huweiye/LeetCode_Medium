package DynamicProgramming;

public class LengthOfLIS {
    public LengthOfLIS() {
        super();
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        int [] dp_max=new int[nums.length];//dp_max[i]表示以元素nums[i]结尾的最长上升子序列的长度，即nums[0]...nums[i]的最长上升子序列必须以nums[i]结尾
        for (int i=0;i<dp_max.length;i++
             ) {
            dp_max[i]=1;
        }
        int target_length=dp_max[0];

        for(int j=1;j<nums.length;j++){


            int temp=1;
            for(int i=0;i<j;i++){

               if(nums[i]<nums[j]){
                   temp=dp_max[i]+1;
               }
               if(temp>dp_max[j]){
                   dp_max[j]=temp;
               }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(dp_max[i]>target_length){
                target_length=dp_max[i];
            }
        }
        return target_length;


    }
}
