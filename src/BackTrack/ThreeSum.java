package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public ThreeSum() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int [] nums;
    int n;
    public List<List<Integer>> threeSum(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        Arrays.sort(this.nums);
        backtrack(0,0);
        return res;
    }
    private void backtrack(int start,int path_sum){
        if(one_answer.size()==3){
            if(path_sum==0){
                res.add(new ArrayList<>(one_answer));
                return;
            }else{
                return;
            }
        }
        for(int i=start;i<n;i++){//求的是组合，for循环从当前元素开始
            if(i>start&&nums[i]==nums[i-1]) continue;
            one_answer.add(nums[i]);
            path_sum+=nums[i];
            backtrack(i+1,path_sum);
            path_sum-=nums[i];
            one_answer.remove(one_answer.size()-1);
        }

    }
}
