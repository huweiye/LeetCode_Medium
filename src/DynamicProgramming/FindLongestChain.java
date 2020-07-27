package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {
    public FindLongestChain() {
        super();
    }
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        if(n==1) return 1;

        //先排序，再求最长数对链
        Arrays.sort(pairs,new Comparator<int[] >() {
            @Override
            public int compare(int[] A, int[] B) {//按数对里前面的那个数排序
                if (A[0] > B[0]) return 1;
                else if (A[0] < B[0]) return -1;
                else return 0;
            }
        });


        int [] dp_len=new int[n];//dp[i]表示以pairs[i]这个数对结尾的最长链的长度
        for(int i=0;i<n;i++) dp_len[i]=1;


        for(int i=1;i<n;i++){
            int temp = 1;
            for(int j=0;j<i;j++) {
                if (pairs[i][0] > pairs[j][1]) {//前面的链加上pairs[i]能组成链
                    temp=dp_len[j] + 1;
                }
                //不能组成链则使用默认值1
                if(temp>dp_len[i]){//以pairs[i]这个数对结尾的最长的可能
                    dp_len[i]=temp;
                }


            }

        }
        return dp_len[n-1];

    }


}
