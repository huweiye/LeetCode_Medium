package DynamicProgramming;

public class FindNumberOfLIS {
    public FindNumberOfLIS() {
        super();
    }
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int [][] dp_num_lis=new int[n][2];//dp[i][0]表示“以nums[i]结尾”的最长递增子序列的长度，dp[i][1]表示对应长度的个数
        dp_num_lis[0][0]=1;
        dp_num_lis[0][1]=1;
        int longest_lis=1;
        int most_num=1;
        for(int i=1;i<n;i++){
            dp_num_lis[i][0]=1;//它自己就是最长的递增子序列
            dp_num_lis[i][1]=1;//只有一个他自己
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]){
                    if(dp_num_lis[j][0]+1==dp_num_lis[i][0]) {
                        dp_num_lis[i][1]+=dp_num_lis[j][1];
                    }
                    else if(dp_num_lis[j][0]+1>dp_num_lis[i][0]){
                        dp_num_lis[i][0]=dp_num_lis[j][0]+1;
                        dp_num_lis[i][1]=dp_num_lis[j][1];
                    }else{
                        //nothing
                    }
                }else{
                    //nothing
                }
            }
            if(dp_num_lis[i][0]==longest_lis){
                most_num+=dp_num_lis[i][1];
            }
            else if(dp_num_lis[i][0]>longest_lis){
                longest_lis=dp_num_lis[i][0];
                most_num=dp_num_lis[i][1];
            }
        }
        return most_num;


    }
}
