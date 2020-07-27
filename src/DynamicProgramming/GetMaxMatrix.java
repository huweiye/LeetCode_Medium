package DynamicProgramming;

public class GetMaxMatrix {
    public GetMaxMatrix() {
        super();
    }
    int j1_max=0;
    int j2_max=0;
    int i1_max=0;
    int i2_max=0;
    public int[] getMaxMatrix(int[][] matrix) {
        int [] res=new int[4];

        int m=matrix.length;//行数
        int n=matrix[0].length;//列数
        int sum=matrix[0][0];//记录最优解
        int [] b=new int[n];//数学公式里的b,调用一维算法的参数nums,b[j]表示在i1,i2固定的情况下，matrix的第j列元素之和。
        // 注意每改变一次i1,i2的值，都要先给b重新置0,然后再算b的每个元素的值

        //通过使用一维情形的动态规划算法解决二维的问题
        for(int i1=0;i1<m;i1++){
            for(int j=0;j<n;j++) {//b[j]表示在i1行和i2行之间，第j列的matrix元素之和
                b[j] = 0;//先置0，再计算
                }
            for(int i2=i1;i2<m;i2++){
                //找能够使t(i1,i2)最大的i1和i2

                    for (int j = 0; j <n; j++) b[j] +=matrix[i2][j];//用到了上一次循环的累加结果，这里每个元素b[j]只需要再加上当前第i2的那一个元素即可

                int[] t=maxSubArray(b);//t(i1,i2)的值


                if(t[0]>sum){
                    sum=t[0];
                    j1_max=t[1];
                    j2_max=t[2];
                    i1_max=i1;
                    i2_max=i2;
                }

            }

        }
        res[0]=i1_max;
        res[1]=j1_max;
        res[2]=i2_max;
        res[3]=j2_max;

        return res;
    }
    public int[] maxSubArray(int[] nums) {
        int[] res=new int[3];//res[0]最优解，res[1]和res[2]分别是最优解时的两个下标

        res[0]=nums[0];
        res[1]=0;
        res[2]=0;
        int [][] dp=new int[nums.length][3];
        dp[0][0]=nums[0];
        dp[0][1]=0;
        dp[0][2]=0;

        for(int j=1;j<nums.length;j++){
            if(dp[j-1][0]>0) {
                dp[j][0]=dp[j-1][0]+nums[j];
                dp[j][1]=dp[j-1][1];
            }
            else{
                dp[j][0]=nums[j];
                dp[j][1]=j;
             }
            dp[j][2]=j;

        }
        for(int j=0;j<nums.length;j++){
            if(dp[j][0]>res[0]){
                res[0]=dp[j][0];
                res[1]=dp[j][1];
                res[2]=dp[j][2];
            }
        }


        return res;
    }
}
