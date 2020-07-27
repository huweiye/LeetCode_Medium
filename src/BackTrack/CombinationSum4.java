package BackTrack;

import java.util.ArrayList;

public class CombinationSum4 {
    /*给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
    * 顺序不同的序列被视作不同的组合。*/
    public CombinationSum4() {
        super();
    }
    ArrayList<Integer> one_answer=new ArrayList<>();
    int [] nums;
    int target;
    int n;
    int sum;//排列个数之和
    public int combinationSum4(int[] nums, int target) {
        this.nums=nums;
        this.n=nums.length;
        this.target=target;
        backtrack(0);
        return sum;
    }
    private void backtrack(int path_sum){
        if(path_sum>=target) return;

        for(int i=0;i<n;i++){//求的是排列，所以for循环要从头开始
            path_sum+=nums[i];
            if(path_sum==target) sum++;
            backtrack(path_sum);
            path_sum-=nums[i];//撤销
        }

    }
}
