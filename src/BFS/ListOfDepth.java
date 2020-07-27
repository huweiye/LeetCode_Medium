package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepth {
    ArrayList<ListNode> res=new ArrayList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue =new LinkedList<>();
        //树没有子节点指向父节点的路径，所以不需要维护visited
        if(tree==null) return res.toArray(new ListNode[0]);
        queue.offer(tree);
        bfs(queue);
        return res.toArray(new ListNode[0]);
    }
    private void bfs(Queue<TreeNode> queue){
        while (!queue.isEmpty()){
            int this_depth=queue.size();//当前这一层有多少节点
            ListNode pre_head=new ListNode(-1);
            ListNode pointer=pre_head;
            for(int i=0;i<this_depth;i++){
                TreeNode node=queue.poll();
                pointer.next=new ListNode(node.val);
                pointer=pointer.next;
                //把左孩子加进去
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.add(pre_head.next);
        }
    }
}
