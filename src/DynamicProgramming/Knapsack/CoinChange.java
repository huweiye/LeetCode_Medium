package DynamicProgramming.Knapsack;

public class CoinChange {
    /*完全背包装满背包所用的最少物品*/
    public CoinChange() {
        super();
    }
    public int coinChange(int[] coins, int amount) {
        //零钱相当于物品，总金额相当于背包容量
        int [] dp=new int[amount+1];//dp[i][j]:对前i个零钱，选若干兑换总金额为j的整钱，最少需要的零钱个数为dp[i][j]

        dp[0]=0;//0个零钱，待兑换总金额为0，最少0个零钱就能满足
        for(int i=1;i<=amount;i++) dp[i]=amount + 1;//0个零钱，待兑换总金额>0，无法兑换
        //因为要求必须恰好装满（即等价兑换），所以这些位置要赋不可能值，因为dp的过程是取Min,所以不可能值应该取尽可能大
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        //一维数组dp[j]里的j指的是背包容量，这里即总金额
        for(int i=1;i<=coins.length;i++){//对前i个零钱,其中第i个零钱是coins[i-1]
            for(int j=coins[i-1];j<=amount;j++){//完全背包正序更新一维数组
                dp[j]=Math.min(dp[j],dp[j-coins[i-1]]+1);//根据背包九讲：求最小价值/最少件数，只需将原始状态转移方程中的max改成min
                //在找零问题中，零钱即物品，只不过零钱的面额相当于其所占的体积，定值1是所有零钱的价值
                //待找零总金额相当于背包容量
                //求恰好等于该背包容量时的物品最小价值
            }
        }
        return dp[amount]==amount + 1?-1:dp[amount];

    }
}
