package DynamicProgramming;

public class NumTrees {
    public NumTrees() {
        super();
    }
    public int numTrees(int n) {
        if(n<=0) return 1;//空树也是二叉搜索树
        //n>=1
        int [] dp_Catalan=new int[n+1];//dp[i]就表示i个节点的情况个数
        dp_Catalan[0]=1;
        dp_Catalan[1]=1;
        //初始化卡特兰数前两项
        for(int i=2;i<=n;i++){
            for(int k=0;k<=i-1;k++){
                dp_Catalan[i]+=dp_Catalan[k]*dp_Catalan[i-k-1];//卡特兰
            }
        }
        return dp_Catalan[n];




    }
}
