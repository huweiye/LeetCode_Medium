package DynamicProgramming;

public class LongestCommonSubsequence {
    public LongestCommonSubsequence() {
        super();
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars_text1=text1.toCharArray();
        char [] chars_text2=text2.toCharArray();
        int [][] dp_len=new int[chars_text1.length+1][chars_text2.length+1];
        for(int i=0;i<=chars_text1.length;i++){
            dp_len[i][0]=0;
        }
        for(int i=0;i<=chars_text2.length;i++){
            dp_len[0][i]=0;
        }
        for(int i=1;i<=chars_text1.length;i++){
            for(int j=1;j<=chars_text2.length;j++){
                if(chars_text1[i-1]==chars_text2[j-1]) dp_len[i][j]=dp_len[i-1][j-1]+1;
                else if(dp_len[i][j-1]>=dp_len[i-1][j]) dp_len[i][j]=dp_len[i][j-1];
                else dp_len[i][j]=dp_len[i-1][j];

            }
        }
        return dp_len[chars_text1.length][chars_text2.length];
    }
}
