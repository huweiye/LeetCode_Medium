package DFS.GraphDFS;

public class FindCircleNum {
    public FindCircleNum() {
        super();
    }
    public int findCircleNum(int[][] M) {//统计无向图的连通分量的个数
        int res=0;
        int n=M.length;//n个顶点
        boolean [] visited=new boolean[n];//Java默认false
        for(int i=0;i<n;i++){
            if(!visited[i]){//当前节点未被访问过,可从它开始dfs
                dfs(M,visited,i);
                res+=1;//主循环里每一次dfs出来就遍历完一个连通子图
            }
        }
        return res;
    }
    public void dfs(int[][] M,boolean [] visited,int i){
        if(visited[i]) return;//当前节点已被访问过
        visited[i]=true;
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1) dfs(M,visited,j);//不需要在此处检查visited[j],因为在递归函数的开头就检查了
        }
    }
}
