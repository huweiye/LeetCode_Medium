package WeekContest.num29;

import java.util.ArrayList;

public class KthFactor {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        int i=1;
        for(;i<=Math.sqrt(n);i++){
            if(n%i==0){
                res.add(i);
            }
        }
            if(k<=res.size()) return res.get(k-1);
            if(((int)Math.sqrt(n)*(int)Math.sqrt(n)==n)&&(k>2*res.size()-1)||((int)Math.sqrt(n)*(int)Math.sqrt(n)!=n)&&(k>2*res.size())) return -1;
            if((int)Math.sqrt(n)*(int)Math.sqrt(n)==n) return n/res.get(2*res.size()-1-k);
            return n/res.get(2*res.size()-k);




    }

}
