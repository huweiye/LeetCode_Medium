package tree;

public class SumEvenGrandparent {
    public SumEvenGrandparent() {
        super();
    }
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;

    }
    public void   dfs(TreeNode node){
        if(node==null) return ;
        if(node.val%2==0){//当前节点是偶数
            //加上当前节点的子孙
            sum+=node.left==null?0:(node.left.left==null?0:node.left.left.val);
            sum+=node.left==null?0:(node.left.right==null?0:node.left.right.val);
            sum+=node.right==null?0:(node.right.left==null?0:node.right.left.val);
            sum+=node.right==null?0:(node.right.right==null?0:node.right.right.val);
        }
        dfs(node.left);
        dfs(node.right);
    }
}
