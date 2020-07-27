package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public SubsetsWithDup() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_path=new ArrayList<>();//一个可能的子集
    int n;
    int [] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        n=nums.length;
        //先排序，这样相同的两个元素必相邻
        Arrays.sort(nums);
        backtarck(0);
        res.add(new ArrayList<Integer>());//补上一个空集
        return res;
    }
    private void backtarck(int i){//将要填入下标为i的元素，也就是说该层从nums[i]处的元素开始for循环
        if(i==n){
            return;
        }
        //再dfs地加子节点
        for(int j=i;j<n;j++){//做的是子集，子集是组合，所以是从当前元素开始遍历

               /*注意“去重”操作是在同层中进行的，不同层的相同元素不能“去重”。
               比如nums=[1，2，2]，根节点有三个子节点，即1，2和2，
               当for循环到该层的最后一个子节点，即重复出现的那个2的时候，需要及时掐断，不再向下递归
               而从该层的第一个子节点，即1处向下dfs到倒数第二层，遇到重复出现的那个2，如果只是单纯的判断它和前面的nums元素相同就不再向下递归，那么子集[1,2,2]就出不来
               因为此时是身处两个不同层的元素的比较
               * */
               /*
               要实现同层比较的关键就是比较for循环里的j和实参i,j是当前检查元素下标；i是开始检查的元素下标
               如果nums[j]是在同层的在for循环里和前面某一个元素重复的，那么j至少大于等于i+1，否则比较的两个元素就处于不同层
               * */
               if(j>i&&nums[j]==nums[j-1]) continue;//同层去重，跳过
               one_path.add(nums[j]);
               res.add(new ArrayList<Integer>(one_path));
               backtarck(j+1);
               one_path.remove(one_path.size()-1);//撤销选择

        }
    }

}
