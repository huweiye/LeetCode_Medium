package DynamicProgramming;

public class LongestPalindromeSubseq {
    public LongestPalindromeSubseq() {
        super();
    }

    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        if(n==0) return 0;
        if(n==1) return 1;
        int [][]dp_len_seq=new int[n][n];//dp_len_seq[i][j]表示字符串s[i...j]的最长回文子序列的长度
        for(int i=0;i<n;i++) dp_len_seq[i][i]=1;//单个字符是一个回文

        for(int r=2;r<=n;r++){//待检查字符串的长度，最长时即整个字符串
            for(int i=0;i<n-r+1;i++){
                if(r==2){//相邻两个字符的情况
                    if(s.charAt(i)==s.charAt(i+1)) dp_len_seq[i][i+1]=2;
                    else dp_len_seq[i][i+1]=1;
                }else{
                    //r>=3的情况
                    int j=i+r-1;
                    if(s.charAt(i)==s.charAt(j)) dp_len_seq[i][j]=dp_len_seq[i+1][j-1]+2;//两端相等
                    //两端不等时，长度为r的最长回文子序列的长度为max(长度为r-1的两个最长回文子序列的长度）
                    else if(dp_len_seq[i+1][j]>dp_len_seq[i][j-1]) dp_len_seq[i][j]=dp_len_seq[i+1][j];
                    else dp_len_seq[i][j]=dp_len_seq[i][j-1];
                }
            }

        }
        return dp_len_seq[0][n-1];

    }

}
