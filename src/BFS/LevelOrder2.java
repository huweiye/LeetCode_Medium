package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder2 {
    Queue<TreeNode> queue=new LinkedList<>();
    ArrayList<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
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
                TreeNode temp_node=queue.poll();
                temp_list.add(temp_node.val);
                if(temp_node.left!=null) queue.offer(temp_node.left);
                if(temp_node.right!=null) queue.offer(temp_node.right);
            }
            res.add(temp_list);
        }
    }
}
