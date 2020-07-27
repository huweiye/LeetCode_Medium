package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class LongestArithSeqLength {
    public LongestArithSeqLength() {
        super();
    }
    public int longestArithSeqLength(int[] A) {
        int n=A.length;
        HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
        ArrayList<Integer> temp;
        for(int i=0;i<n;i++){
            if(hashMap.get(A[i])==null){
                temp=new ArrayList<>();
                temp.add(i);
                hashMap.put(A[i],temp);
            }
            else {hashMap.get(A[i]).add(i);}
        }
        int [][] dp=new int[n][n];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                dp[i][j]=2;//初始化
            }
        }
        int max_len=2;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                ArrayList<Integer> o=hashMap.get(A[i]-(A[j]-A[i]));
                if(o!=null) {
                    for(int k=0;k<o.size();k++){
                        if(o.get(k)<i) {dp[i][j]=dp[o.get(k)][i]+1;}
                    }

                }


                max_len=Math.max(max_len,dp[i][j]);
            }
        }
        return max_len;


    }
}
