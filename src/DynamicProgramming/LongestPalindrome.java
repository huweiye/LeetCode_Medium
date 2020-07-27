package DynamicProgramming;

public class LongestPalindrome {
    public LongestPalindrome() {
        super();
    }
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        char [] s_c=s.toCharArray();
        int n=s_c.length;
        char [] s_chars=new char[n+1];//从下标1处开始使用
        for(int i=1;i<=n;i++){
            s_chars[i]=s_c[i-1];
        }
        int [][] B=logestPaDr(n,s_chars);
        return GetLongestPalindrome(1,n,s_chars,B);
    }
    int[][] logestPaDr(int n,char [] s_char_arr){
        //n待求串长度，为s_char_arr.length-1
        //s_char_arr，待求串S的字符数组形式
        //表H,维护S(i,j)的最长回文子串的长度，H[i][j]处的值即S[i...j]的最长回文字串的长度，只在i<=j处有效，即上三角
        //表B,维护每一个字符串的最长回文子串是怎么来的，B[i][j]即S[i...j]的最长回文子串是怎么来的，用于递归地构造最长回文子串

        int [][] H=new int[n+1][n+1];
        int [][]B=new int[n+1][n+1];
        //表从下标1开始使用
        for(int x=1;x<=n;x++){
            H[x][x]=1;//待求串长度为1，即i==j时，其最长回文子串即他自己
        }
        for(int r=2;r<=n;r++){//r：待求子串的长度，从2增到n
            //每一次循环求完H的一条从对角线,一直到H[1][n]
            for(int i=1;i<=n-r+1;i++){//每一次循环求一个H[i][j]的值
                int j=i+r-1;
                if(s_char_arr[i]==s_char_arr[j]){//首尾字符相等
                    if(i+1>j-1){//aa,bb这样的,此时H[i+1][j-1],会访问到H的下三角形区域，于是直接给H[i][j]赋值
                        H[i][j]=2;
                        B[i][j]=4;
                    }else{//aba,abca这样的，要根据S[i+1..j-1]本身是不是回文做不同的处理
                        if(H[i+1][j-1]==(j-1)-(i+1)+1){//aba,abba这样的，在抛去两端字符后，S[i+1...j-1]仍然是回文，那么S[i..j]也必是回文，直接长度加2
                            H[i][j] = H[i + 1][j - 1] + 2;
                            B[i][j] = 5;//情况5
                        }else{//abca,这样的，抛去两端字符后，中间的S[i+1...j-1]不是回文，则S[i..j]的最长回文子串肯定是max{S[i+1...j]的最长回文子串,S[i...j-1]的最长回文子串}
                            if(H[i+1][j]>=H[i][j-1]){
                                H[i][j]=H[i+1][j];
                                B[i][j]=2;//情况2
                            }else{
                                H[i][j]=H[i][j-1];
                                B[i][j]=3;//情况3
                            }
                        }

                    }
                }else{//首尾字符不相等，那么S[i..j]的最长回文子串肯定是是S[i+1...j-1]的最长回文子串
                    if(H[i+1][j]>=H[i][j-1]){
                        H[i][j]=H[i+1][j];
                        B[i][j]=2;//情况2
                    }else{
                        H[i][j]=H[i][j-1];
                        B[i][j]=3;//情况3
                    }
                }
            }
        }
        //H，B求完了
        //H[1][n]即S的最长回文子串长度
        //B记录了生成最长回文子串的路径
        //这俩用到哪个返回哪个
        return B;



    }


    String GetLongestPalindrome(int i,int j,char [] s_char_arr,int [][]B){

        if(i==j){
            return String.valueOf(s_char_arr[i]);//一个字符
        }
        if(B[i][j]==5){//形如abcba
            return String.valueOf(s_char_arr[i])+GetLongestPalindrome(i+1,j-1,s_char_arr,B)+String.valueOf(s_char_arr[i]);
        }
        else if(B[i][j]==4){//形如aa
            return String.valueOf(s_char_arr[i])+String.valueOf(s_char_arr[i]);
        }
        else if(B[i][j]==2){
            return GetLongestPalindrome(i+1,j,s_char_arr,B);
        }else if(B[i][j]==3){
            return GetLongestPalindrome(i,j-1,s_char_arr,B);
        }
        else {
            System.out.println("wrong");
            return "";//在回溯B的时候，只会回溯到其值为1，2，3的时候，不可能执行到else
        }


    }

}
