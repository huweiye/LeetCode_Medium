package other.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ClassTable2 {
    public ClassTable2() {
        super();
    }
    ArrayList<Integer> res=new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //构造邻接表和入度数组
        ArrayList<Integer> [] adjacencyList=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) adjacencyList[i]=new ArrayList<>();
        int [] inDegree=new int[numCourses];
        //下标为i，节点是i,用下标表示节点
        for (int [] edge:prerequisites) {
            adjacencyList[edge[1]].add(edge[0]);//想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]:1----->0
            inDegree[edge[0]]++;
        }
        //拓扑排序
        topologicalSort(adjacencyList,inDegree);
        if(res.size()==numCourses)
             return res.stream().mapToInt(Integer::valueOf).toArray();
        else
             return new int[0];
    }
    private void topologicalSort(ArrayList<Integer> [] adjacencyList,int [] inDegree){
        int nums=inDegree.length;
        Queue<Integer> q=new LinkedList<>();//入度为0的节点队列
        for(int i=0;i<nums;i++){
            if(inDegree[i]==0) q.offer(i);
        }
        while (!q.isEmpty()){
            int node=q.poll();
            res.add(node);//添加到拓扑排序输出路径中
            for (int child_node:adjacencyList[node]) {
                inDegree[child_node]--;
                if(inDegree[child_node]==0){
                    q.offer(child_node);
                }
            }
        }
    }

}
