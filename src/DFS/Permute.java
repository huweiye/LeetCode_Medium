package DFS;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /*交换元素的办法求全排列
    * */
    public Permute() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        perm(nums,0,nums.length-1);
        return res;
    }
    public void perm(int [] nums,int flag,int end){//flag,end分别是前缀末位和后缀末位
        if(flag==end){//前缀固定，只剩下最后一个元素求其全排列，就是他本身
            ArrayList<Integer> a_perm=new ArrayList<>();
            for (int n:nums) a_perm.add(n);
            res.add(a_perm);
        }
        else {

            for (int i = flag; i <=end; i++) {
                swap(nums, flag, i);
                perm(nums, flag+1 , end);
                swap(nums, flag, i);
            }
        }

    }
    public void swap(int [] nums,int l,int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}
