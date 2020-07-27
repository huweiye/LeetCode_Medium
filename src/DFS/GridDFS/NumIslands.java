package DFS.GridDFS;

public class NumIslands {
    public NumIslands() {
        super();
    }

    public int numIslands(char[][] grid) {
        int sum=0;//岛屿数量
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,m,n);//主循环里每调用一次dfs得到一个完整的岛屿（连通区域）
                    sum+=1;
                }
            }
        }
        return sum;
    }
    private void dfs(char[][] grid,int i,int j,int m,int n){
        if(i<0||i>=m||j<0||j>=n) return ;//越界
        if(grid[i][j]=='0') return ;//是海洋
        if(grid[i][j]=='-') return ;//重复访问
        grid[i][j]='-';
        dfs(grid,i-1,j,m,n);
        dfs(grid,i+1,j,m,n);
        dfs(grid,i,j-1,m,n);
        dfs(grid,i,j+1,m,n);
    }
}
