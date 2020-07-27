package DynamicProgramming.Knapsack;

public class CombinationSum4 {
    /*完全背包恰好装满背包的考虑放入顺序的方案数*/

    public CombinationSum4() {
        super();
    }
    /*考虑放入物品的顺序时：
    只需要将不考虑顺序的两个for循环内外顺序对换即可
    * */
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int [] dp=new int[target+1];//dp[i][j]：对前i个物品来说，要填满容量为j的背包的方案数
        dp[0]=1;//对前0个物品来说，容量为0的背包可以用“空”填满



        //两个for循环内外顺序对换
        for(int j=1;j<=target;j++){//对背包容量为j时
            for(int i=1;i<=n;i++){//对前i个物品来说
                if(j>=nums[i-1])
                dp[j]+=dp[j-nums[i-1]];
            }
        }
        return dp[target];
    }

}
