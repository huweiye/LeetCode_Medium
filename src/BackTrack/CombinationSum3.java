package BackTrack;

import java.util.ArrayList;
import java.util.List;

//无重复数组的0-1取用的指定目标和的定长组合问题
public class CombinationSum3 {
    /*找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。*/
    public CombinationSum3() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int [] candidates=new int[]{1,2,3,4,5,6,7,8,9};
    int target;
    int len_n=9;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        target=n;
        this.k=k;
        backtrack(0,0);
        return res;
    }
    private void backtrack(int start,int path_sum){
        if(one_answer.size()>=k||path_sum>=target) return;

        for(int i=start;i<len_n;i++){//求的组合，所以for循环要从当前元素开始
            one_answer.add(candidates[i]);
            if(one_answer.size()==k&&path_sum+candidates[i]==target){
                res.add(new ArrayList<>(one_answer));
            }
            backtrack(i+1,path_sum+candidates[i]);
            one_answer.remove(one_answer.size() - 1);//撤销
        }


    }
}
