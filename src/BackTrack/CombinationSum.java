package BackTrack;

import java.util.ArrayList;
import java.util.List;

//无重复数组的无限取用的指定目标和的组合问题
public class CombinationSum {
    /*
 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates 中的数字可以无限制重复被选取
*/
    public CombinationSum() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int[] candidates;
    int target;
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;
        this.n=candidates.length;//解空间树的宽度
        backtrack(0,0);
        return res;
    }
    private void backtrack(int start,int path_sum){//求的组合，所以for循环要从当前元素开始
        if(path_sum>=target){//因为数组元素都是正整数，path_sum不可能减少
            return;
        }
        //求的组合，所以for循环要从当前元素开始
        for(int i=start;i<n;i++){//同层宽度是candidates元素个数
            one_answer.add(candidates[i]);
            if(path_sum+candidates[i]==target){
                res.add(new ArrayList<>(one_answer));
            }
            backtrack(i, path_sum + candidates[i]);//元素使用次数无限，所以candidates[i]还可以再被使用，所以下一层递归也是从当前元素开始
            one_answer.remove(one_answer.size() - 1);//撤销
        }

    }
}
