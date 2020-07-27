package tree;

import java.util.ArrayList;

public class InorderSuccessor {
    public InorderSuccessor() {
        super();
    }
    ArrayList<TreeNode> mid_tree=new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root);
        int target=mid_tree.indexOf(p);
        return target==-1||target==mid_tree.size()?null:mid_tree.get(target+1);
    }
    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        mid_tree.add(node);
        dfs(node.right);
    }

}
