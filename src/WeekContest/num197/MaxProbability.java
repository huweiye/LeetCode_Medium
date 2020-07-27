package WeekContest.num197;

public class MaxProbability {
    /*邻接矩阵表示的无向图的DFS*/
    double [][]matrix;//邻接矩阵
    boolean[] visited;
    int end;
    double res=0.0;
    double one_soution=1.0;
    int n;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if(succProb.length==0) return 0;
        this.n=n;
        this.end=end;
        matrix=new double[n][n];
        visited=new boolean[n];
        for(int i=0;i<edges.length;i++){
            matrix[edges[i][0]][edges[i][1]]=succProb[i];
            matrix[edges[i][1]][edges[i][0]]=succProb[i];
        }
        dfs(start);
        return res;
    }
    private void dfs(int node){
        if(Math.abs(res-one_soution)<1e-5) return;
        if(node==end){
            res=Math.max(res,one_soution);
            return;
        }
        for(int i=0;i<n;i++){
            if(matrix[node][i]!=0&&!visited[i]) {
                visited[node]=true;
                one_soution*=matrix[node][i];
                dfs(i);
                visited[i]=false;
                one_soution/=matrix[node][i];
            }
        }
    }
}
