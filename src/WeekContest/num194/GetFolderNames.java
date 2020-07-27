package WeekContest.num194;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GetFolderNames {
    public GetFolderNames() {
        super();
    }
    public String[] getFolderNames(String[] names) {
        int n=names.length;
        HashMap<String,Integer> hashMap=new HashMap<>();
        Set<String> set=new HashSet();
        String [] res=new String[n];
        for (int i=0;i<n;i++){
            String suc="";
            int k=0;
            if(hashMap.containsKey(names[i])) k=hashMap.get(names[i]);
            while (set.contains(names[i]+suc)){
                k++;
                suc="("+k+")";
            }
            hashMap.put(names[i],k);
            set.add(names[i]+suc);
            res[i]=names[i]+suc;
        }
        return res;
    }
}
