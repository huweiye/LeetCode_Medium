package BinaryDivide;

import java.util.ArrayList;

public class KthGrammar {
    public KthGrammar() {
        super();
    }
    public ArrayList<String> lookup_str=new ArrayList<>();
    public int kthGrammar(int N, int K) {
        String s=rec_getstr(N);
        return s.charAt(K-1)-'0';
    }
    public String rec_getstr(int n){
       if(n==0) return "";
       if(n<=lookup_str.size()) return lookup_str.get(n-1);
        String last_str=rec_getstr(n-1);//上一行的字符串

        String res="";
        if(last_str.length()==0) {res="0";}
       else {
            for (int i = 0; i < last_str.length(); i++) {
                if (last_str.charAt(i) == '0') {
                    res += "01";
                } else {
                    res += "10";
                }
            }
        }
        lookup_str.add(res);
        return res;

    }
}
