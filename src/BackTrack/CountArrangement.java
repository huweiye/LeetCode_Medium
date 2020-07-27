package BackTrack;

import java.util.ArrayList;

public class CountArrangement {
    public CountArrangement() {
        super();
    }
    ArrayList<Integer> one_permute=new ArrayList<>();//一个全排列
    int n;
    int sum;
    boolean [] visited;
    public int countArrangement(int N) {
        n=N;
        visited=new boolean[n+1];
        backtrack();
        return sum;
    }
    private void backtrack(){
        if(!one_permute.isEmpty()&&!is_beautiful()) return;
        if(one_permute.size()==n) {
            sum++;
            return;
        }
        for(int i=1;i<=n;i++){//求的是排列，for循环从头开始
            if(!visited[i]){//数字i未被使用过
                visited[i]=true;
                one_permute.add(i);
                backtrack();
                one_permute.remove(one_permute.size()-1);//撤销
                visited[i]=false;//撤销
            }
        }
    }
    private boolean is_beautiful(){
            if(one_permute.get(one_permute.size()-1)%(one_permute.size())==0) return true;
            else if((one_permute.size())%one_permute.get(one_permute.size()-1)==0) return true;
            else return false;
    }
}
