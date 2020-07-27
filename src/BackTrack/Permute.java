package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {//全排列数f(n)=n!(定义0!=1)
    public Permute() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_permute=new ArrayList<>();//当前正在遍历的路径记录上的一个排列
    int [] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        backtrack();
        return res;
    }
    private void backtrack(){//已经产生了前i-1个位置的数的全排列情况下，去产生第i个位置的数
        if(one_permute.size()==nums.length){
            ArrayList<Integer> temp=new ArrayList<>();//因为res存的是List的首地址，所以每次需要开辟新的内存空间
            for (int t:one_permute) {temp.add(t);}
            res.add(temp);
            return;
            }
            for(int j=0;j<nums.length;j++){
            //第i个位置的数可能是nums里的任一个元素，但条件是它没有在前面出现过
                if(isValid(j)){
                    one_permute.add(nums[j]);//第i个位置可以放nums[j]
                    backtrack();
                    one_permute.remove(one_permute.size()-1);//撤销前面放的操作
                }
        }
    }
    private boolean isValid(int j){//因为nums不重复，所以可以通过从one_permute查找已经使用过的数字来实现
        for (int front_num:one_permute) {
            if(front_num==nums[j]) return false;//前面出现过了，不能放
        }
        return true;//前面没出现过这个数，可以放
    }
}
