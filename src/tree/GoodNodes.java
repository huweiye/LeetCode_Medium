package tree;

public class GoodNodes {
    public GoodNodes() {
        super();
    }
    int sum=0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return sum;
    }
    public void dfs(TreeNode node,int max_value){
        if(node==null) return;
        if(node.val>=max_value){
            sum++;
            max_value=node.val;
        }
        dfs(node.left,max_value);
        dfs(node.right,max_value);

    }
}
