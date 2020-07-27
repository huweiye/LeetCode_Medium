package tree;

public class Flatten {

    public void flatten(TreeNode root) {
        if(root==null) return;
        dfs(root);

    }
    private TreeNode dfs(TreeNode node){
        if(node==null) return null;
        if(node.left==null&&node.right==null) return node;
        TreeNode left=dfs(node.left);
        TreeNode right=dfs(node.right);
        node.left=null;
        if(left!=null) {
            node.right = left;
            TreeNode temp=node;
            while(temp.right != null) temp=temp.right;
            temp.right=right;

        }else{
            node.right=right;
        }
        return node;
    }
}
