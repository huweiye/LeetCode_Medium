package DynamicProgramming;

public class NthPersonGetsNthSeat {
    public NthPersonGetsNthSeat() {
        super();
    }

    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1.0;
        double [] dp=new double[n+1];//从下标1开始使用
        dp[2]=0.5;
        double sum_dp=1.5;
        for(int i=3;i<=n;i++){
            dp[i]=(1.0/(double)i)*sum_dp;
            sum_dp+=dp[i];
        }
        return dp[n];

    }
}
