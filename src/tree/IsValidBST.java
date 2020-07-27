package tree;

import java.util.ArrayList;

public class IsValidBST {
    public IsValidBST() {
        super();
    }
    ArrayList<Integer> mid_tree=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i=0;i<mid_tree.size()-1;i++){
            if(mid_tree.get(i)>=mid_tree.get(i+1)) return false;
        }
        return true;

    }
    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        mid_tree.add(node.val);
        dfs(node.right);
    }
}
