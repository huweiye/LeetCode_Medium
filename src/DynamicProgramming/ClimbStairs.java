package DynamicProgramming;

public class ClimbStairs {
    public ClimbStairs() {
        super();
    }
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int [] m=new int[n+1];
        m[1]=1;//爬一节楼梯只有一种可能
        m[2]=2;//不会outindex
        for(int i=3;i<=n;i++){//从第三阶楼梯开始算
            m[i]=m[i-1]+m[i-2];
        }
        return m[n];
    }
}
