package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public Subsets() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_subset=new ArrayList<>();//存储遍历一个完整路径得到的子集
    int [] nums;
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        n=this.nums.length;
        dfs(0);
        return res;
    }
    private void dfs(int i){//nums的下标
        if(i==nums.length){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int num:one_subset) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        for(int flag=0;flag<=1;flag++){//对于nums[i],只有两种可能，选和不选
            if(flag==0){//不选
                dfs(i+1);
                //无需撤销
            }else{//选
                one_subset.add(nums[i]);
                dfs(i+1);
                one_subset.remove(one_subset.size()-1);//需要撤销当前选择
            }
        }
    }
    private void backtarck(int i){//将要填入下标为i的元素，也就是说该层从nums[i]处的元素开始for循环
        if(i==n){
            return;
        }
        //再dfs地加子节点
        for(int j=i;j<n;j++){//做的是子集，子集是组合，所以是从当前元素开始遍历
            one_subset.add(nums[j]);
            res.add(new ArrayList<Integer>(one_subset));
            backtarck(j+1);
            one_subset.remove(one_subset.size()-1);//撤销选择
        }
    }

}
