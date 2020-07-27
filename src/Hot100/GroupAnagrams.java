package Hot100;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hashMap=new HashMap<>();
        for (String str:strs) {
            char [] chars_str=str.toCharArray();
            Arrays.sort(chars_str);
            String sorted_str=new String(chars_str);
            if(hashMap.containsKey(sorted_str)) hashMap.get(sorted_str).add(str);
            else{ArrayList<String> list=new ArrayList<>();list.add(str);hashMap.put(sorted_str,list);}
        }
        ArrayList<List<String>> res=new ArrayList<>();
        for (ArrayList l:hashMap.values()) res.add(l);
        return res;

    }
}
