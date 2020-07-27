package DynamicProgramming.Knapsack;

public class Change {
    /*完全背包恰好装满背包方案数问题*/
    public Change() {
        super();
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int []dp=new int[amount+1];
        //dp[i][j]表示从前i个零钱里选择若干去兑换面额为j的整钞
        dp[0]=1;//从0个零钱里去兑换面额为0的整钱是可兑换的，一个方案
        //面额>0的情况无法兑换，取方案数为默认值0
        for(int i=1;i<=n;i++){//前i个零钱，第i个零钱是coin[i-1]
            for(int j=coins[i-1];j<=amount;j++){//待兑换面额为j，只有j>=coins[i-1]时，才会新增兑换方案数
                //根据背包九讲，完全背包问题正序更新一维数组
                dp[j]=dp[j]+dp[j-coins[i-1]];
            }
        }
        return dp[amount];


    }
}
