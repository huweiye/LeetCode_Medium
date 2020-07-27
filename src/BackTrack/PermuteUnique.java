package BackTrack;

import java.util.*;

public class PermuteUnique {
    public PermuteUnique() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_solution=new ArrayList<>();
    int [] nums;
    int n;
    HashMap<Integer,Integer> map=new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums=nums;
        n=this.nums.length;
        for (int each_num:nums) map.put(each_num,map.getOrDefault(each_num,0)+1);
        //使用哈希表保证遍历解空间树时，同层节点不重复
        backtrack();
        return res;
    }

    private void backtrack(){
        if(one_solution.size()==n){//产生了一个全排列
            res.add(new ArrayList<Integer>(one_solution));
            return;
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if(entry.getValue()!=0){
                map.replace(entry.getKey(),entry.getValue()-1);
                one_solution.add(entry.getKey());
                backtrack();
                one_solution.remove(one_solution.size()-1);//撤销
                map.replace(entry.getKey(),entry.getValue()+1);//撤销
            }
        }
    }

}
