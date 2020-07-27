package DynamicProgramming;

public class NumSquares {
    public NumSquares() {
        super();
    }
    public int numSquares(int n) {
        if(n==1) return 1;
        int []dp_min=new int[n+1];//从下标1开始使用，下标即待求数字
        dp_min[1]=1;//数字1是完全平方数
        for(int i=2;i<=n;i++){//从2开始填dp表，填到n
            if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i){//i本身是完全平方数
                dp_min[i]=1;//就是他自己
                continue;
            }
            //i不是完全平方数
            dp_min[i]=dp_min[1]+dp_min[i-1];
            for(int j=2;j<=i/2;j++){
                if(dp_min[j]+dp_min[i-j]<dp_min[i]) dp_min[i]=dp_min[j]+dp_min[i-j];//最少=最少+最少
            }
        }
        return dp_min[n];




    }
}
