package tree;

public class MaxAncestorDiff {
    public MaxAncestorDiff() {
        super();
    }
    int res=0;
    public int maxAncestorDiff(TreeNode root) {
    dfs(root,root.val,root.val);
    return res;
    }
    public void dfs(TreeNode node,int max_value,int min_value){
        if(node==null) return;
        res=Math.max(res,Math.max(Math.abs(max_value-node.val),Math.abs(min_value-node.val)));
        if(node.val>max_value) max_value=node.val;
        if(node.val<min_value) min_value=node.val;
        dfs(node.left,max_value,min_value);
        dfs(node.right,max_value,min_value);
    }
}
