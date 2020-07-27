package DynamicProgramming;

import java.util.HashMap;

public class LenLongestFibSubseq {
    public LenLongestFibSubseq() {
        super();
    }
    public int lenLongestFibSubseq(int[] A) {
        int n=A.length;
        HashMap<Integer,Integer> find_k=new HashMap<>();
        for(int i=0;i<n;i++){
            find_k.put(A[i],i);//A严格递增
        }
        int [][] dp_ij=new int[n][n];//以A[i],A[j]结尾的最长斐波那契子序列长度，即...A[i],A[j]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp_ij[i][j] = 2;
            }
        }
        int max_len=0;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                Object k=find_k.get(A[j]-A[i]);
                if(k!=null){

                    if((int)k<i) dp_ij[i][j]=dp_ij[(int)k][i]+1;
                }
                max_len=Math.max(max_len,dp_ij[i][j]);

            }
        }
        return max_len>2?max_len:0;

    }
}
