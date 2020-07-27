package Hot100;

public class Exist {
    char[][] board;
    String word;
    boolean[][]visited;
    int m;
    int n;
    boolean res=false;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        m=board.length;
        n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)&&!visited[i][j]){
                    dfs(i,j,1);
                }
            }
        }
        return res;
    }
    private void dfs(int i,int j,int next_char){
        if(next_char==word.length()){
            res=true;
            return;
        }
        visited[i][j]=true;
        if(res==false&&i-1>=0&&board[i-1][j]==word.charAt(next_char)&&!visited[i-1][j]) {//确定还没找到的情况下再去找
            dfs(i-1,j,next_char+1);
        }
        if(res==false&&i+1<m&&board[i+1][j]==word.charAt(next_char)&&!visited[i+1][j]) {//确定还没找到的情况下再去找
            dfs(i+1,j,next_char+1);
        }
        if(res==false&&j-1>=0&&board[i][j-1]==word.charAt(next_char)&&!visited[i][j-1]) {//确定还没找到的情况下再去找
            dfs(i,j-1,next_char+1);
        }
        if(res==false&&j+1<n&&board[i][j+1]==word.charAt(next_char)&&!visited[i][j+1]) {//确定还没找到的情况下再去找
            dfs(i,j+1,next_char+1);
        }
        visited[i][j]=false;//不是一条dfs路径上的节点可以被重复访问
    }

}
