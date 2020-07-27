package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder3 {
    Queue<TreeNode> queue= new LinkedList<>();
    ArrayList<List<Integer>> res=new ArrayList<>();
    int level=0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
        queue.offer(root);
        bfs();
        return res;
    }
    private void bfs(){
        while (!queue.isEmpty()){
            int width=queue.size();
            ArrayList<Integer> one_level=new ArrayList<>();
            for(int i=0;i<width;i++){
                TreeNode node=queue.poll();
                if(level%2==0) one_level.add(node.val);//从左往右
                else{
                    one_level.add(0,node.val);
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            level++;
            res.add(one_level);
        }
    }
}
