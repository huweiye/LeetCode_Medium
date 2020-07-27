package Hot100;


public class LowestCommonAncestor {
/*
* 当我们用递归去做这个题时不要被题目误导，应该要明确一点
这个函数的功能有三个：给定两个节点 p 和 q

如果 p 和 q 都存在，则返回它们的公共祖先；
如果只存在一个，则返回存在的一个；
如果 p 和 q 都不存在，则返回NULL
*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;//递归终止条件，叶子节点或者找到了p/q
        TreeNode left=lowestCommonAncestor(root.left,p,q);//查左子树
        TreeNode right=lowestCommonAncestor(root.right,p,q);//查右子树
        if(left!=null&&right!=null) return root;//p，q分别位于root的左右子树中，此时他们的最近公共祖先一定是root
        if(left==null) return right;//只在右子树中找到了，此时找到的right要么是p和q的最近公共祖先，要么就是p或者q本身;也有可能没找到，返回null
        else return left;
    }

}
