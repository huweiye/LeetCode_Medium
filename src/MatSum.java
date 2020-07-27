public class MatSum { //前缀和
    int [][] mat;
    int m;
    int n;
    int[][] S;//前缀和矩阵必须是全局变量，一次计算，多次使用
    public MatSum(int [][]mat) {
        this.mat=mat;
        m=mat.length;
        n=mat[0].length;
        S=new int[m][n];//前缀和矩阵必须是全局变量，一次计算，多次使用
    }

    public int get_squ(int x1, int y1, int x2, int y2){//二维数组前缀和求子矩阵和，O(n^2)
        //前缀和：https://blog.csdn.net/XT_NOI/article/details/72715904
        //求左上角[x1,y1],右下角[x2,y2]的子矩阵和
        //本质上是DP的方法
        //先求矩阵S：S[i,j]=a[i,j]+S[i−1,j]+S[i,j−1]−S[i−1,j−1]
        //再一次计算出子矩阵和：S(x1,y1,x2,y2)=S(1,1,x2,y2)+S(1,1,x1−1,y1−1)−S(1,1,x1−1,y2)−S(1,1,x2,y1−1)=S[x2][y2]+S[x1-1][y1-1]-S[x1-1][y2]-S[x2][y1-1]
        S[0][0]=mat[0][0];
        for(int i=1;i<m;i++) S[i][0]=S[i-1][0]+mat[i][0];
        for(int j=1;j<n;j++) S[0][j]=S[0][j-1]+mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                S[i][j]=mat[i][j]+S[i-1][j]+S[i][j-1]-S[i-1][j-1];//本质上是DP
            }
        }
        return S[x2][y2]+(x1-1<0||y1-1<0?0:S[x1-1][y1-1])-(x1-1<0?0:S[x1-1][y2])-(y1-1<0?0:S[x2][y1-1]);
    }
}
