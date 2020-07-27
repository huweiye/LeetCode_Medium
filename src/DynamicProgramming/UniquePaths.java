package DynamicProgramming;

public class UniquePaths {
    public UniquePaths() {
        super();
    }
    public int uniquePaths(int m, int n) {
        int [][] route_amount=new int[m][n];
        route_amount[0][0]=1;
        for(int i=1;i<m;i++) route_amount[i][0]=route_amount[i-1][0];//只能从上面来
        for(int i=1;i<n;i++) route_amount[0][i]=route_amount[0][i-1];//只能从左面来
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                route_amount[i][j]=route_amount[i-1][j]+route_amount[i][j-1];
            }
        }
        return route_amount[m-1][n-1];

    }
}
