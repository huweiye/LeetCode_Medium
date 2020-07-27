package tree;

public class CountNodes {
    public CountNodes() {
        super();
    }
    int sum=0;
    public int countNodes(TreeNode root) {
       dfs_tree(root);
       return sum;

    }
    public void dfs_tree(TreeNode node){
        if(node==null) return;
        sum++;
        dfs_tree(node.left);
        dfs_tree(node.right);

    }
}
