package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder4 {
    ArrayList<Integer> res=new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        if(root==null) return res.stream().mapToInt(Integer::valueOf).toArray();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            res.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
