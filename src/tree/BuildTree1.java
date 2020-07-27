package tree;

public class BuildTree1 {
    public BuildTree1() {
        super();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recur(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode recur(int[] postorder, int left1,int right1,int[]inorder ,int left2,int right2){//左闭右闭
        if(left1>right1||left2>right2) return null;
        TreeNode node=new TreeNode(postorder[right1]);//后序遍历的末元素是当前树的根节点
        for(int i=left2;i<=right2;i++){
            if(inorder[i]==postorder[right1]){
                //右子树长：right2-i
                //左子树长：i-left2
                node.left=recur(postorder,left1,left1+(i-left2)-1,inorder,left2,left2+(i-left2)-1);//左子树
                node.right=recur(postorder,left1+(i-left2),right1-1,inorder,i+1,right2);//右子树
            }
        }
        return node;


    }

}
