package tree;

public class DeepestLeavesSum {
    public DeepestLeavesSum() {
        super();
    }
    int sum=0;
    int deepest=0;
    public int deepestLeavesSum(TreeNode root) {

dfs(root,0);
return sum;
    }
    public void dfs(TreeNode node,int level){
        if(node==null) return;;
        if(node.left==null&&node.right==null) {//找到更深的叶子节点了
            if(level>deepest){
                sum=node.val;
                deepest=level;
            }
            else if(level==deepest){//同是最深层的叶子
                sum+=node.val;
            }
        }
        dfs(node.left,level+1);
        dfs(node.right,level+1);


    }
}
