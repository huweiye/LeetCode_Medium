package DynamicProgramming;

public class MinScoreTriangulation {
    public MinScoreTriangulation() {
        super();
    }
    public int minScoreTriangulation(int[] A) {
        int n=A.length-1;//(n+1)边形
        int [][] m=new int[n+1][n+1];//从下标1处开始使用，1...n
        for(int i=1;i<=n;i++) m[i][i]=0;

        for(int r=2;r<=n;r++){

            for(int i=1;i<=n-r+1;i++){
                int j=i+r-1;
                m[i][j]=m[i][i]+m[i+1][j]+A[i-1]*A[i]*A[j];
                for(int k=i+1;k<=j-1;k++){
                    if(m[i][k]+m[k+1][j]+A[i-1]*A[k]*A[j]<m[i][j]) m[i][j]=m[i][k]+m[k+1][j]+A[i-1]*A[k]*A[j];
                }
            }
        }
        return m[1][n];



    }
}
