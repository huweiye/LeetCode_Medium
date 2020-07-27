package DynamicProgramming;

public class UniquePathsWithObstacles {
    public UniquePathsWithObstacles() {
        super();
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] route_count=new int[m][n];
        if(obstacleGrid[0][0]==0) route_count[0][0]=1;


        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]==0) route_count[i][0]=route_count[i-1][0];
        }
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j]==0) route_count[0][j]=route_count[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0) route_count[i][j]=route_count[i-1][j]+route_count[i][j-1];
            }
        }
        return route_count[m-1][n-1];

    }
}
