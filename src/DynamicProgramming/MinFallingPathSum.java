package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinFallingPathSum {
    public MinFallingPathSum() {
        super();
    }
    public int minFallingPathSum(int[][] A) {
        int m=A.length,n=m;
        if(m==1) return A[0][0];
        int [] dp_min_path=new int[n];

        for(int i=0;i<n;i++) dp_min_path[i]=A[0][i];

        //dp---
        int [] temp=new int[n];//临时数组
        for(int i=1;i<m;i++){

            for (int x=0;x<n;x++) temp[x]=dp_min_path[x];//DP过程使用的是temp

            for(int j=0;j<n;j++){
                if(j==0) dp_min_path[0]=Math.min(temp[0],temp[1])+A[i][0];
                else if(j==n-1) dp_min_path[n-1]=Math.min(temp[n-2],temp[n-1])+A[i][n-1];
                else{
                    dp_min_path[j]=Math.min(Math.min(temp[j-1],temp[j]),temp[j+1])+A[i][j];
                }

            }
        }
        Arrays.sort(dp_min_path);
        return dp_min_path[0];


    }
}
