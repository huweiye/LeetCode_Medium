package DFS.GraphDFS;

public class CanFinish {
    public CanFinish() {
        super();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //先构造邻接矩阵
        int [][] AdjacencyMatrix=new int[numCourses][numCourses];
        int [] visited=new int[numCourses];//记录访问情况
        // dfs的时候，0：当前节点尚未访问过；1：当前节点在其他轮的dfs中被访问过了；2：当前节点在本轮dfs中被访问过了，有环
        for (int [] pre:prerequisites) {
            AdjacencyMatrix[pre[1]][pre[0]]=1;//pre[1]指向pre[0]的一条边
        }
        for(int i=0;i<numCourses;i++){//节点i
            if(visited[i]==0) {
                if (!dfs(AdjacencyMatrix, visited, i)) return false;//有一个环就直接返回
            }
        }
        return true;
    }
    private boolean dfs(int [][] AdjacencyMatrix,int [] visited,int i){
        if(visited[i]==2) return false;//在主循环的一轮dfs中访问了同一个节点两次，有回路
        visited[i]=2;
        for(int j=0;j<AdjacencyMatrix.length;j++){
            if(AdjacencyMatrix[i][j]==1){
                if(dfs(AdjacencyMatrix,visited,j)==false) return false;
            }
        }
        visited[i]=1;//从节点i开始的dfs结束，下一次
        return true;
    }
}
