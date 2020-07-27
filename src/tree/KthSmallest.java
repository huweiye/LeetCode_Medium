package tree;

import java.util.ArrayList;


public class KthSmallest {
    public KthSmallest() {
        super();
    }
    ArrayList<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        rec_dfs(root);
        return res.get(k-1);
    }
    public void rec_dfs(TreeNode node){
        if(node==null) return;
        rec_dfs(node.left);
        res.add(node.val);
        rec_dfs(node.right);
    }

}
