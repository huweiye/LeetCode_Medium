package tree;

public class DistributeCoins {
    public DistributeCoins() {
        super();
    }
    int res=0;
    //拿走和拿来两个动作是等价的，dfs时针对一个具体的节点，只考虑从当前节点拿走多少而不考虑拿入，因为拿走负数个金币就等价于拿入对应金币
    public int distributeCoins(TreeNode root) {
        //后序遍历，先让左右子树从根节点拿走金币使左右子树满足条件,再计算使根节点金币数为1需要拿走的金币数目
        //如果左右子树金币多，那么从根节点拿负数个金币==从左右子树取出对应数目的金币给根节点
        dfs(root);
        return res;
    }
    public int dfs(TreeNode node){//返回使当前节点的金币数为1的，需要拿出的金币数目
        if(node==null) return 0;
        int l=dfs(node.left);//要使左子树满足题意，需要从左子树拿走的金币数目,可能==0，正数或负数
        res+=Math.abs(l);//移动次数即拿走的金币绝对值
        int r=dfs(node.right);
        res+=Math.abs(r);
        return l+r+node.val-1;//此时当前节点node金币数目为（l+r+node.val），返回保留一个金币需要拿走的金币数
    }
}
