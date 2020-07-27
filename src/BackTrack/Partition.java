package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public Partition() {
        super();
    }
    ArrayList<List<String>> res=new ArrayList<>();
    ArrayList<String> one_answer=new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(s);
        return res;



    }
    private void backtrack(String str){
        if(str.equals("")){
            res.add(new ArrayList<>(one_answer));
            return;
        }
        for(int i=0;i<str.length();i++){
            String left=str.substring(0,i+1);
            if(is_palindrome(left)){//被截取部分是回文
                one_answer.add(left);
                backtrack(str.substring(i+1,str.length()));
                one_answer.remove(one_answer.size()-1);
            }
        }
    }
    private boolean is_palindrome(String s){
        int n=s.length();
        for (int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)) return false;
        }
        return true;
    }
}
