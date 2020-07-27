package other.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ClassTable {
    public ClassTable() {
        super();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {//numCourses个结点的有向图
        int n=prerequisites.length;//n条边
        ArrayList<Integer> [] adjacencyList=new ArrayList[numCourses];//邻接表
        int [] inDegree=new int[numCourses];//入度数组，inDegree[i]的值表示节点i的入度
        //先由边的集合构建邻接表
        for(int i=0;i<numCourses;i++){
            adjacencyList[i]=new ArrayList<>();//节点i的下标为i
        }
        for (int [] pre:prerequisites) {
            adjacencyList[pre[1]].add(pre[0]);//pre=[0,1],1是边的起始点，0才是终点，是节点1指向节点0
            inDegree[pre[0]]++;
        }
        //拓扑排序判断是不是DAG
        return topologicalSort(adjacencyList,inDegree,numCourses);
    }
    private boolean topologicalSort(ArrayList<Integer> [] adjacencyList,int [] inDegree,int n){//邻接表和入度数组
        int res=0;//拓扑排序能取出来的节点数目
        Queue<Integer> queue=new LinkedList<Integer>();//存储入度为0的节点
        for(int i=0;i<n;i++){
            if(inDegree[i]==0) queue.offer(i);//节点i的入度为0，添加进队列
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();//取出节点i
            res++;
            for (int child_of_i : adjacencyList[i]) {//对节点i指向的每一个节点
                inDegree[child_of_i]--;
                if (inDegree[child_of_i] == 0) queue.offer(child_of_i);
            }

        }
        return res==n;
    }

}
