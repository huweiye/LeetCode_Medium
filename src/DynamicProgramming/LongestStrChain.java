package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStrChain {
    public LongestStrChain() {
        super();
    }

    public int longestStrChain(String[] words) {//词链并不是words的子序列，而是任意位置选择的单词组成的
        int n = words.length;
        if (n == 1) return 1;
        //先把字符串数组按照长度从短到长排序
        Arrays.sort(words, new LengthComparator());//Arrays.sort可以传入一个comparator对象
        int[] dp = new int[n];//dp[i]表示以words[i]结尾的最长词链
        dp[0] = 1;//长度最短的单词，以他结尾的词链是它本身
        int longest = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j <= i - 1; j++) {
                if (words[j].length() == words[i].length() - 1) {//只有前一个单词长度是当前单词长度-1的情况下，才有可能构成词链
                    if (is_wordlist(words[j],words[i])) dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            longest= Math.max(longest,dp[i]);
        }
        return longest;

    }
    public boolean is_wordlist(String front,String back){
        boolean flag=false;
        for(int i=0;i<back.length();i++){
            String temp=back.substring(0,i)+back.substring(i+1);
            if(temp.equals(front)) return true;
        }
        return flag;
    }


    class LengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }


    }
}
