package DynamicProgramming.Knapsack;

public class FindTargetSumWays {
    /*01背包恰好装满的方案数*/
    public FindTargetSumWays() {
        super();
    }
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        int len=nums.length;
        for (int n:nums) {
            sum+=n;
        }
        int target;
        if(sum < Math.abs(S) ||(sum+S)%2!=0) return 0;
        target=(sum+S)/2;//背包承重
        int [] dp=new int[target+1];
        dp[0]=1;//表示从前0个物品中选取若干放入背包承重量为0的恰好装满的方案数
        for(int i=1;i<=len;i++){
            for(int j=target;j>=nums[i-1];j--){
                dp[j]=dp[j]+dp[j-nums[i-1]];
            }
        }
        return dp[target];

    }
}
