package DynamicProgramming;

public class MaximalSquare {
    public MaximalSquare() {
        super();
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        if(matrix[0].length==0) return 0;
        int m=matrix.length;//行数
        int n=matrix[0].length;//列数
        int max_side_len=0;//初始化最大可能的边长
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')   max_side_len=1;//初始化最大可能的边长
            }
        }
        if(m==1||n==1) return max_side_len;


        for(int x=2;x<=Math.min(m,n);x++){//边长
            char temp_x[][]=new char[m-x+1][n-x+1];//temp_x[i][j]存放左上起始坐标为i,j,边长为x的那个正方形的状态，它的状态由其四部分决定
            for(int i=0;i<temp_x.length;i++){
                for(int j=0;j<temp_x[0].length;j++){
                    if(matrix[i][j]=='1'&matrix[i][j+1]=='1'&&matrix[i+1][j]=='1'&&matrix[i+1][j+1]=='1') {
                        temp_x[i][j]='1';
                        if(x>max_side_len) max_side_len=x;
                    }
                    else {temp_x[i][j]='0';}
                }
            }
            for(int i=0;i<temp_x.length;i++) {
                for (int j = 0; j < temp_x[0].length; j++) {
                    matrix[i][j]=temp_x[i][j];
                }
            }


        }
        return max_side_len*max_side_len;


    }
}
