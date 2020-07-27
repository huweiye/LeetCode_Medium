package tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    ArrayList<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        rec_dfs(root);
        return res;
    }
    public void rec_dfs(TreeNode node){
        if(node==null) return;
        res.add(node.val);
        rec_dfs(node.left);
        rec_dfs(node.right);
    }
}
