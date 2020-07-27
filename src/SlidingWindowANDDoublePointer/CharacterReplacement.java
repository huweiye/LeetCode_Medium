package SlidingWindowANDDoublePointer;

import java.util.HashMap;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        /*条件：k>=当前窗口大小-窗口里某个字符的最大重复出现次数
        只要满足该条件，窗口就还能扩张
        * */
        int n=s.length();
        HashMap<Character,Integer> windows=new HashMap<>();
        int max_char=0;//最大重复出现次数
        int left=0,right=0;
        int res=0;
        while (right<n){
            windows.put(s.charAt(right),windows.getOrDefault(s.charAt(right),0)+1);
            max_char=Math.max(windows.get(s.charAt(right)),max_char);
            if(k>=(right-left+1)-max_char){
                 res=Math.max(res,right-left+1);
            }else{
                windows.replace(s.charAt(left),windows.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }
        return res;
    }
}
