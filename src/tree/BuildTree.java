package tree;

public class BuildTree {
    public BuildTree() {
        super();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length-1;//区间左右闭合
        return recur(preorder,0,n,inorder,0,n);
    }
    public TreeNode recur(int[] preorder, int left1,int right1,int[] inorder,int left2,int right2){
        if(left1>right1||left2>right2) return null;
        TreeNode root=new TreeNode(preorder[left1]);//前序遍历的当前的首元素即正在构造的树的根节点
        for(int i=left2;i<=right2;i++){//去中序遍历里找根节点，用以区分左右子树
            if(inorder[i]==root.val){//树中没有重复元素，一定能找得到
                //(i-left2)是左子树的长度
                root.left=recur(preorder,left1+1,left1+(i-left2),inorder,left2,i-1);
                root.right=recur(preorder,left1+(i-left2)+1,right1,inorder,i+1,right2);
            }
        }
        return root;
    }

}
