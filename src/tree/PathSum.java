package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public PathSum() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target=sum;
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode node,int path_sum){
        if(node==null) return;
        if(node.left==null&&node.right==null){
            if(path_sum+node.val==target) {
                one_answer.add(node.val);
                res.add(new ArrayList<>(one_answer));
                one_answer.remove(one_answer.size()-1);
                return;
            }
            else return;
        }
        one_answer.add(node.val);
        path_sum=path_sum+node.val;
        dfs(node.left,path_sum);
        dfs(node.right,path_sum);
        one_answer.remove(one_answer.size()-1);
    }
}
