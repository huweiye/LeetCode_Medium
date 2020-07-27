package DynamicProgramming;

public class CountNumbersWithUniqueDigits {
    public CountNumbersWithUniqueDigits() {
        super();
    }
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int [] dp=new int[n+1];//从下标1开始使用
        dp[1]=10;//一位数
        dp[2]=81;//两位数：9*9
        int sum=dp[1]+dp[2];
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]*(10-i+1);
            sum+=dp[i];
        }
        return sum;


    }

}
