package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public Permutation() {
        super();
    }
    ArrayList<String> res=new ArrayList<>();
    String one_permute=new String();//当前正在遍历的路径记录上的一个排列
    String S;
    public String[] permutation(String S) {
        this.S=S;
        backtrack();
        return (String[])res.toArray();
    }
    private void backtrack(){
        if(one_permute.length()==S.length()){
            res.add(one_permute);
            return;
        }
        for(int j=0;j<S.length();j++){
            if(isValid(j)){
                one_permute+=S.charAt(j);
                backtrack();
                one_permute=one_permute.substring(0,one_permute.length()-1);//撤销前面放的操作
            }
        }
    }
    private boolean isValid(int j){
         for(int i=0;i<one_permute.length();i++){
            if(one_permute.charAt(i)==S.charAt(j)) return false;//前面出现过了，不能放
        }
        return true;//前面没出现过，可以放
    }

}
