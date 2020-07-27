package DFS.GridDFS;

public class ClosedIsland {
    public ClosedIsland() {
        super();
    }

    int [][] grid;
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        this.grid=grid;
         m=grid.length;
         n=grid[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) {
                    if(dfs(i,j)) res++;
                }
            }
        }
        return res;
    }
    private boolean dfs(int i,int j){
        if(i<0||i>=m||j<0||j>=n)  return false;
        if(grid[i][j]==1) return true;
        if(grid[i][j]==2) return true;
        grid[i][j]=2;
        boolean res1=dfs(i-1,j);
        boolean res2=dfs(i+1,j);
        boolean res3=dfs(i,j-1);
        boolean res4=dfs(i,j+1);
        return res1&&res2&&res3&&res4;
    }
}
