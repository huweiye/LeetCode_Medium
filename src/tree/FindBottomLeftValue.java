package tree;

public class FindBottomLeftValue {
    public FindBottomLeftValue() {
        super();
    }
    int max_level=1;
    int left_value;
    public int findBottomLeftValue(TreeNode root) {
        left_value=root.val;
        dfs(root,1);
        return left_value;
    }
    public void dfs(TreeNode node,int level){
        if(node==null) return;
        if(level>max_level){max_level=level; left_value=node.val;}
        dfs(node.right,level+1);
        dfs(node.left,level+1);
    }
}
