package tree;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public RightSideView() {
        super();
    }
    ArrayList<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
dfs(root,0);
return res;
    }
    public void dfs(TreeNode node,int level){
        if(node==null) return;
        if(level<res.size()) res.set(level,node.val);//更新同层更右侧的
        else res.add(node.val);//添加
        dfs(node.left,level+1);
        dfs(node.right,level+1);

    }
}
