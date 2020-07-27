package DFS.GridDFS;

import java.util.ArrayList;

public class Solve {
    char [][] board;
    boolean[][] visited;//dfs访问的是网格，是二维数组的每一个点，而邻接矩阵表示的图dfs的时候依旧是访问的图的顶点
    ArrayList<int[]> one_solution=new ArrayList<>();//记录一个“连通分量”的坐标
    int m;
    int n;
    public void solve(char[][] board) {
        this.board=board;
        this.m=board.length;
        if(m==0) return;
        this.n=board[0].length;
        if(n==0) return;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&&!visited[i][j]){
                    if (dfs(i,j)) {change();}//每次只改变一个连通分量
                    one_solution=new ArrayList<>();
                }

            }
        }

    }
    private boolean dfs(int i,int j){
        if(i<0||i>=m||j<0||j>=n){//当前的连通分量在某一个方向上能够出界，说明当前连通分量不是被包围的
            return false;
        }
        if(visited[i][j]) return true;//防止环绕
        if(board[i][j]=='X') return true;
        //是一个未访问的'O'
        visited[i][j]=true;
        one_solution.add(new int[]{i,j});
        boolean res1=dfs(i-1,j);
        boolean res2=dfs(i+1,j);
        boolean res3=dfs(i,j-1);
        boolean res4=dfs(i,j+1);
        return res1&&res2&&res3&&res4;
    }
    private void change(){
        for (int [] position:one_solution) {
            board[position[0]][position[1]]='X';
        }

    }

}
