package DFS.GridDFS;

public class MaxAreaOfIsland {
    public MaxAreaOfIsland() {
        super();
    }
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){//是土地，且尚未被访问过
                    res=Math.max(res,dfs(grid,i,j,m,n));
                }
            }
        }
        return res;

    }
    private int dfs(int[][] grid,int i,int j,int m,int n){//二维数组的dfs
        if(i<0||i>=m||j<0||j>=n) return 0;//越界
        if(grid[i][j]==0) return 0;//是海洋
        if(grid[i][j]==-1) return 0;//已经访问过了
        grid[i][j]=-1;//标记
        int area=1;//当前节点是尚未被访问过的陆地，面积至少为1
        area+=dfs(grid,i-1,j,m,n);//返回grid[i][j]上面方向的所有的岛屿面积
        area+=dfs(grid,i+1,j,m,n);
        area+=dfs(grid,i,j-1,m,n);
        area+=dfs(grid,i,j+1,m,n);
        return area;
    }
}
