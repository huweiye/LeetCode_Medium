package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//带重复数组的0-1取用的指定目标和的组合问题
public class CombinationSum2 {
    /*
    * 给定一个可能含有重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates 中的每个数字在每个组合中只能使用一次。
*/
    public CombinationSum2() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int[] candidates;
    int target;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;
        this.n=candidates.length;
        Arrays.sort(candidates);
        backtrack(0,0);
        return res;
    }
    private void backtrack(int start,int path_sum){//即将往one_answer里填入第start个元素candidates[start]
        if(path_sum>=target){//因为数组元素都是正整数，path_sum不可能减少
            return;
        }
        for(int i=start;i<n;i++){//组合，从当前元素开始循环
            if(i>start&&candidates[i]==candidates[i-1]) continue;//同层去重
            one_answer.add(candidates[i]);
            if(path_sum+candidates[i]==target) res.add(new ArrayList<>(one_answer));
            backtrack(i+1,path_sum+candidates[i]);//当前元素已经被使用过了，所以candidates[i]不可以再被使用，所以下一层递归也是从下一个元素开始
            one_answer.remove(one_answer.size()-1);
        }
    }
}
