package SlidingWindowANDDoublePointer;

import java.util.HashMap;

public class CheckInclusion {
    public CheckInclusion() {
        super();
    }
    public boolean checkInclusion(String s1, String s2) {//s1有可能含有重复元素
        char [] target_char=s1.toCharArray();
        char [] source_char=s2.toCharArray();
        int n=source_char.length;
        HashMap<Character,Integer> target_map=new HashMap<>();
        for (char c:target_char) target_map.put(c,target_map.getOrDefault(c,0)+1);

        HashMap<Character,Integer> window_map=new HashMap<>();
        int left=0,right=0;
        int nonce=0;//满足条件的不同字符数
        while (right<n){
            window_map.put(source_char[right],window_map.getOrDefault(source_char[right],0)+1);
            if(target_map.containsKey(source_char[right])){
                if(window_map.get(source_char[right]).intValue()==target_map.get(source_char[right]).intValue()){
                    nonce++;
                }
            }
            right++;
            if(right-left==target_char.length){
                if(nonce==target_map.size()) return true;
                else{
                    if(target_map.containsKey(source_char[left])&&window_map.get(source_char[left]).intValue()==target_map.get(source_char[left]).intValue()){
                        nonce--;
                    }
                    window_map.replace(source_char[left],window_map.get(source_char[left])-1);
                    left++;
                }
            }
        }
        return false;


    }
}
