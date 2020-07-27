package DynamicProgramming;

public class CountSubstrings {
    public CountSubstrings() {
        super();
    }
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int sum=0;//s里回文子串的个数
        int n=s.length();//字符串长度
        sum+=n;//对角线上的先加上
        boolean [][]count_palindrome=new boolean[n][n];//从下标0处开始使用
        for(int i=0;i<n;i++) count_palindrome[i][i]=true;

        //填表方向与矩阵连乘积问题相同，只是针对每一个当前问题，用到的已解决子问题的位置不同
        for(int r=2;r<=n;r++){//待检查字符串长度
            for(int i=0;i<n-r+1;i++){
                int j=i+r-1;
                if(r==2){//俩字符
                    if(s.charAt(i)==s.charAt(j)){count_palindrome[i][j]=true; sum+=1;}
                    else count_palindrome[i][j]=false;
                }else{//r>=3
                    count_palindrome[i][j]=count_palindrome[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                    if(count_palindrome[i][j]) sum+=1;
                }

            }

        }

        return sum;
    }
}
