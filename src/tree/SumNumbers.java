package tree;

public class SumNumbers {
    public SumNumbers() {
        super();
    }
    int sum=0;
    public int sumNumbers(TreeNode root) {
dfs(root,0);
return sum;

    }
    public void dfs(TreeNode node,int temp){
        if(node==null) return ;
        if(node.left==null&&node.right==null) {sum+=(temp*10+node.val);return;};
        temp=temp*10+node.val;
        dfs(node.left,temp);
        dfs(node.right,temp);

    }
}
