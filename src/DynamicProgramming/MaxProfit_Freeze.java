package DynamicProgramming;

public class MaxProfit_Freeze {
    public MaxProfit_Freeze() {
        super();
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;


        //冷冻期有两天，当天卖出（不持有），前一天卖出（不持有），所以冷冻期一定不持有，所以不持有状态被分成了两种状态：冷冻，不冷冻
        //对于每一天，都有可能是三种状态：0.不持股且非冷冻期；2.持股；3.不持股且冷冻期；
        int [][] dp=new int[n][3];//dp[i][0]表示i天不持股但可以买入；dp[i][1]表示第i天持股；dp[i][2]表示i天不持股且不可买入（冷冻期）
        dp[0][0]=0;
        dp[0][1]=-1*prices[0];
        dp[0][2]=0;
        /**第i天不持股且不是冷冻期的状态，可能来自：i-1天不持股不是冷冻期dp[i-1][0]；i-1天不持股但是冷冻期dp[i-1][2]；
         * dp[i][0]=max(dp[i-1][0],dp[i-1][2])
        * */
        /**i天持股，可能来自：i-1天持股；i-1天不持股且非冷冻期，i天买入；
         * dp[i][1]=max(dp[i-1][1],dp[i-1][0]-p[i])
         *
        * */
        /*i天是冷冻期，则i-1天一定卖出
        dp[i][2]=dp[i-1][0]+p[i]
        * */

        for(int i=1;i<n;i++){//从[1]...[n-1]
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];

        }

        return Math.max(dp[n-1][0],dp[n-1][2]);


    }
}
