package other.prefixSum;

public class MatrixBlockSum {
    public MatrixBlockSum() {
        super();
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m=mat.length;
        int n=mat[0].length;
        int [][] res=new int[m][n];
        int [][] S=new int[m][n];//前缀和矩阵
        //先求前缀和矩阵
        S[0][0]=mat[0][0];
        for(int i=1;i<m;i++) S[i][0]=S[i-1][0]+mat[i][0];
        for(int j=1;j<n;j++) S[0][j]=S[0][j-1]+mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                S[i][j]=S[i-1][j]+S[i][j-1]-S[i-1][j-1]+mat[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=sub_sum_mat(i-K<0?0:i-K,j-K<0?0:j-K,i+K>=m?m-1:i+K,j+K>=n?n-1:j+K,S);
            }
        }
        return res;

    }
    public int sub_sum_mat(int x1,int y1,int x2,int y2,int[][] S){
        return S[x2][y2]-(x1-1<0?0:S[x1-1][y2])-(y1-1<0?0:S[x2][y1-1])+(x1-1<0||y1-1<0?0:S[x1-1][y1-1]);
    }

}
