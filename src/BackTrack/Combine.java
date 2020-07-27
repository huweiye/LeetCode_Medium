package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public Combine() {
        super();
    }
    ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_combine=new ArrayList<>();//一条路径，一个组合
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        //k是解空间树的深度，n决定了解空间树的宽度
        backtrack(1);
        return res;
    }
    private void backtrack(int j){
        if(one_combine.size()==k){//找到一个完整的组合了
            ArrayList<Integer> temp=new ArrayList<>(one_combine);//一条路径，一个组合
            res.add(temp);
            return;
            }
            for(int i=j;i<=n;i++){//组合的关键是递归外层的循环，循环是从当前元素开始，而排列是从头开始的
                    one_combine.add(i);//i可行，选择i
                    backtrack(i+1);
                    one_combine.remove(one_combine.size()-1);//撤销选择
        }
    }

}
