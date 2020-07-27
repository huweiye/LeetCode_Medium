package DFS.GridDFS;

public class NumEnclaves {
    public NumEnclaves() {
        super();
    }
    int [][] A;
    int m;
    int n;
    int sum;
    public int numEnclaves(int[][] A) {
        m=A.length;
        n=A[0].length;
        this.A=A;
        boolean [][] visited=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]==1&&!visited[i][j]){
                    if(!dfs(i,j,visited)) res+=sum;
                }
                sum=0;
            }
        }
        return res;
    }
    private boolean dfs(int i,int j,boolean[][]visited){
        if(i==0||i==(m-1)||j==0||j==(n-1)) {//边界上的点可被多次访问，因为到达同一个边界上的点可能有多条路径
            if(A[i][j]==0) return false;
            else{
                sum++;
                return true;
            }
        }
        //内部的点只能被访问一次，防止出现回路死循环
        if(A[i][j]==0) return false;
        if(visited[i][j]) return false;
        visited[i][j]=true;
        sum++;
        boolean res1=dfs(i-1,j,visited);
        boolean res2=dfs(i+1,j,visited);
        boolean res3=dfs(i,j-1,visited);
        boolean res4=dfs(i,j+1,visited);
        return res1||res2||res3||res4;
    }
}
