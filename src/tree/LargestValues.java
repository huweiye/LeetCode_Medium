package tree;

import java.util.ArrayList;
import java.util.List;

public class LargestValues {
    public LargestValues() {
        super();
    }
    public List<Integer> largestValues(TreeNode root) {

        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;//空列表
        if(root.left==null&&root.right==null) {res.add(root.val);return res;}//左右子树为空，叶子节点
        List<Integer> left_max=largestValues(root.left);//取左子树每一层的最大值列表
        List<Integer> right_max=largestValues(root.right);//取右子树每一层的最大值列表
        for(int i=0;i<Math.max(left_max.size(),right_max.size());i++){
            //逐层比较
            if(i<left_max.size()&&i<right_max.size()) res.add(Math.max(left_max.get(i),right_max.get(i)));
            else if(i>=left_max.size()) res.add(right_max.get(i));
            else res.add(left_max.get(i));
        }
        res.add(0,root.val);
        return res;
    }
    public void levelOrder(TreeNode root, List<Integer> res, int level) {//当前root是第level层
        if(root==null) return;
        if(level>=res.size()) {res.add(root.val);}
        else {
            int max_value = Math.max(res.get(level), root.val);
            res.set(level, max_value);
        }
        levelOrder(root.left,res,level+1);
        levelOrder(root.right,res,level+1);


    }
}
