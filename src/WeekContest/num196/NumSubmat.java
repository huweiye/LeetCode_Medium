package WeekContest.num196;

import java.util.ArrayList;

public class NumSubmat {
    int [][] mat;
    int m;
    int n;
    int[][] S;//前缀和矩阵必须是全局变量，一次计算，多次使用
    int res=0;
    public int numSubmat(int[][] mat) {
        this.mat=mat;
        m=mat.length;
        n=mat[0].length;
        S=new int[m][n];//前缀和矩阵必须是全局变量，一次计算，多次使用
        get_squ();
        for(int i1=0;i1<m;i1++){
            for(int j1=0;j1<n;j1++){
                for(int i2=i1;i2<m;i2++) {
                    for(int j2=j1;j2<n;j2++){
                        if(sub_sum_mat(i1,j1,i2,j2)==(i2-i1+1)*(j2-j1+1)) res++;
                    }
                }
                }
            }

        return res;
    }
    public void get_squ(){//二维数组前缀和求子矩阵和，O(n^2)
        S[0][0]=mat[0][0];
        for(int i=1;i<m;i++) S[i][0]=S[i-1][0]+mat[i][0];
        for(int j=1;j<n;j++) S[0][j]=S[0][j-1]+mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                S[i][j]=mat[i][j]+S[i-1][j]+S[i][j-1]-S[i-1][j-1];//本质上是DP
            }
        }
    }
    public int sub_sum_mat(int x1,int y1,int x2,int y2){
        return S[x2][y2]-(x1-1<0?0:S[x1-1][y2])-(y1-1<0?0:S[x2][y1-1])+(x1-1<0||y1-1<0?0:S[x1-1][y1-1]);
    }

}
