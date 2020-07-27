package SlidingWindowANDDoublePointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public FindAnagrams() {
        super();
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        char[] s_chars=s.toCharArray();
        char [] p_chars=p.toCharArray();
        HashMap<Character,Integer> target_map=new HashMap<>();
        for (char each_p:p_chars) target_map.put(each_p,target_map.getOrDefault(each_p,0)+1);
        HashMap<Character,Integer> windows_map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        int left=0,right=0;
        int nonce=0;//满足字母出现个数的不同字符种数

        while (right<n){
            windows_map.put(s_chars[right],windows_map.getOrDefault(s_chars[right],0).intValue()+1);
            if(target_map.containsKey(s_chars[right])){
                if(target_map.get(s_chars[right]).intValue()==windows_map.get(s_chars[right]).intValue()){
                    nonce++;//一个字母的数目满足要求了
                }
            }
            right++;
            if(right-left==p.length()){
                if(nonce==target_map.size()) res.add(left);
                if(target_map.containsKey(s_chars[left])&&windows_map.get(s_chars[left]).intValue()==target_map.get(s_chars[left]).intValue()){
                    nonce--;
                }
                windows_map.replace(s_chars[left],windows_map.get(s_chars[left]).intValue()-1);
                left++;
            }

        }
        return res;




    }
}
