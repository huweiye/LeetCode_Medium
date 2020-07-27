package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    Queue<Node> queue=new LinkedList<>();
    ArrayList<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return res;
        //树不存在子节点指向父节点的指针，所以不需要维护visited
        queue.offer(root);
        bfs();
        return res;


    }
    private void bfs(){
        while (!queue.isEmpty()){
            int width=queue.size();
            ArrayList<Integer> temp_list=new ArrayList<>();
            for(int i=0;i<width;i++){
                Node temp_node=queue.poll();
                temp_list.add(temp_node.val);
                List<Node> child=temp_node.children;
                if (child!=null){
                   for(int x=0;x<child.size();x++){
                       queue.offer(child.get(x));
                   }
                }

            }
            res.add(temp_list);
        }
    }

}
