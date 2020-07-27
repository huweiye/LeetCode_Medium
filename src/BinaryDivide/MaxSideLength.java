package BinaryDivide;

public class MaxSideLength {
    public MaxSideLength() {
        super();
    }
    int[][] S;//前缀和矩阵必须是全局变量，一次计算，多次使用
    int m;
    int n;
    public int maxSideLength(int[][] mat, int threshold) {
         m=mat.length;
         n=mat[0].length;
        S=new int[m][n];
        prefix(mat);//计算出二维数组前缀和矩阵，O(n^2)

        int left=1;
        int right=Math.min(m,n);//子正方形边长取值的上边界
        int mid=-1;
        int res=0;
        while (left<=right){//查右边界（满足条件的最大值）
            mid=(left+right)/2;//当前子正方形边长为mid
            if(get_max_squ(mat,mid,threshold)){ left=mid+1;res=mid;}//存在满足题意的边长为mid的子正方形，要进一步查找，缩小到右半区间
            else right=mid-1;//不存在满足题意的mid长的子正方形，边长太大了，缩小到左半区间
        }
        return res;//没有满足题意的正方形的话会直接返回res的默认值，还是0
    }
    public boolean get_max_squ(int[][] mat,int side,int threshold){
        //根据正方形边长，分别确定子正方形的左上角和右下角
        for(int x1=0;x1<=m-side;x1++){//左上角点的行
            for(int y1=0;y1<=n-side;y1++){//左上角点的列
                int x2=x1+side-1;
                int y2=y1+side-1;
                ////求左上角[x1,y1],右下角[x2,y2]的子矩阵和记为S(x1,y1,x2,y2)
                //利用前缀和矩阵S一次性计算出子矩阵和S(x1,y1,x2,y2)
                //公式：S(x1,y1,x2,y2)=S(1,1,x2,y2)+S(1,1,x1−1,y1−1)−S(1,1,x1−1,y2)−S(1,1,x2,y1−1)=S[x2][y2]+S[x1-1][y1-1]-S[x1-1][y2]-S[x2][y1-1]
                if((S[x2][y2]+(x1-1<0||y1-1<0?0:S[x1-1][y1-1])-(x1-1<0?0:S[x1-1][y2])-(y1-1<0?0:S[x2][y1-1]))<=threshold) return true;
            }

        }
        return false;
    }
    public void prefix(int [][] mat){//二维数组前缀和求子矩阵和，O(n^2)
        //前缀和：https://blog.csdn.net/XT_NOI/article/details/72715904
        //本质上是DP的方法
        //求前缀和矩阵S
        // 公式：S[i,j]=a[i,j]+S[i−1,j]+S[i,j−1]−S[i−1,j−1]
        S[0][0]=mat[0][0];
        for(int i=1;i<m;i++) S[i][0]=S[i-1][0]+mat[i][0];
        for(int j=1;j<n;j++) S[0][j]=S[0][j-1]+mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                S[i][j]=mat[i][j]+S[i-1][j]+S[i][j-1]-S[i-1][j-1];//本质上是DP
            }
        }
    }

}
