package DynamicProgramming;

public class FindLength {
    public FindLength() {
        super();
    }
    public int findLength(int[] A, int[] B) {
        int len_a=A.length;
        int len_b=B.length;
        if(len_a==0||len_b==0) return 0;
        int res=0;
        int [][] dp=new int[len_a][len_b];
        for(int i=0;i<len_a;i++) {
            if(A[i]==B[0]) {res=1;dp[i][0]=1;}
        }
        for(int j=0;j<len_b;j++) {
            if(A[0]==B[j]) {res=1;dp[0][j]=1;}
        }
        for(int i=1;i<len_a;i++){
            for(int j=1;j<len_b;j++){
                if(A[i]==B[j]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>res) res=dp[i][j];
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return res;



    }
}
