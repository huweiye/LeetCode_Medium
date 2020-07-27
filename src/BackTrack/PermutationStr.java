package BackTrack;

import java.util.*;

public class PermutationStr {
    public PermutationStr() {
        super();
    }
    ArrayList<String> res=new ArrayList<>();
    String one_solution=new String();
    String S;
    int n;
    HashMap<String,Integer> map=new HashMap<>();//用hashmap去重
    public String[] permutation(String S) {
        this.S=S;
        n=S.length();
        for(int i=0;i<n;i++){
            map.put(S.substring(i,i+1),map.getOrDefault(S.substring(i,i+1),0)+1);
        }
        backtrack();
        return res.toArray(new String[0]);
    }
    private void backtrack(){
        if(one_solution.length()==n){//产生了一个全排列
            res.add(one_solution);
            return;
        }
        Iterator<Map.Entry<String,Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String,Integer> entry = entries.next();
            if(entry.getValue()!=0){
                map.replace(entry.getKey(),entry.getValue()-1);
                one_solution+=entry.getKey();
                backtrack();
                one_solution=one_solution.substring(0,one_solution.length()-1);//撤销
                map.replace(entry.getKey(),entry.getValue()+1);//撤销
            }
        }
    }
}
