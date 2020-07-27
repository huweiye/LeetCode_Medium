package Hot100;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    String [] phone=new String[10];
    int n;//数字个数
    ArrayList<String> res=new ArrayList<>();
    String one_answer=new String();
    String digits;
    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        n=digits.length();
        if(n==0) return res;
        phone[2]="abc";
        phone[3]="def";
        phone[4]="ghi";
        phone[5]="jkl";
        phone[6]="mno";
        phone[7]="pqrs";
        phone[8]="tuv";
        phone[9]="wxyz";
        dfs(0);
        return res;
    }
    private void dfs(int i){
        if(i==n){
            res.add(one_answer);
            return;
        }
        String letters=phone[Integer.valueOf(digits.substring(i,i+1))];
        for(int j=0;j<letters.length();j++){
            one_answer+=letters.charAt(j);
            dfs(i+1);
            one_answer=one_answer.substring(0,one_answer.length()-1);
        }

    }
}
