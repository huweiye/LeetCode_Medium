package DynamicProgramming.Knapsack;

public class CanPartition {
    /*0-1背包能否恰好装满背包*/
    public CanPartition() {
        super();
    }
    public boolean canPartition(int[] nums) {
        int len=nums.length;
        int sum=0;
        for (int n:nums) {
            sum+=n;
        }
        if(sum%2!=0) return false;//整数相加不可能得小数
        int W=sum/2;//相当于背包总承重
        int [][]dp=new int[len+1][W+1];
        //dp[i][j]表示前i个数字，背包承重为j的情况下的
        for(int i=1;i<=len;i++){
            for(int j=1;j<=W;j++){
                dp[i][j]=dp[i-1][j];//不放i
                if(j>=nums[i-1]) dp[i][j]=Math.max(dp[i][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
            }
        }
        return dp[len][W]==W;
    }
    public boolean canPartition1(int[] nums) {
        int len=nums.length;
        int sum=0;
        for (int n:nums) {
            sum+=n;
        }
        if(sum%2!=0) return false;//整数相加不可能得小数
        int W=sum/2;//相当于背包总承重
        int []dp=new int[W+1];
        //在第i轮外循环中，dp[j]表示前i个数字，背包承重为j的情况下的最大值
        for(int i=1;i<=len;i++){
            for(int j=W;j>=nums[i-1];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i-1]]+nums[i-1]);
            }
        }
        return dp[W]==W;
    }
}
