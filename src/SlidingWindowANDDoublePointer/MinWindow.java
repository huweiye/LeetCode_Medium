package SlidingWindowANDDoublePointer;

import java.util.HashMap;

public class MinWindow {
    public MinWindow() {
        super();
    }
    public String minWindow(String s, String t) {
        int n=s.length();//窗口右边界
        HashMap<Character,Integer> map_t=new HashMap<>();
        HashMap<Character,Integer> map_window=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map_t.put(t.charAt(i),map_t.getOrDefault(t.charAt(i),0)+1);
        }
        //窗口指针初始化
        int left=0, right=0;
        int nonce=0;//记录当前窗口能够满足t里出现字符的种数
        String res="";
        while (right<n){
            map_window.put(s.charAt(right),map_window.getOrDefault(s.charAt(right),0)+1);//每当扩展一个字符，不管他在不在t里，都扩展进滑窗里
            if(map_t.containsKey(s.charAt(right))){
                if(map_t.get(s.charAt(right)).intValue()==map_window.get(s.charAt(right)).intValue()){//满足一种字符的出现次数了
                    nonce++;
                }
            }
            right++;
            while (nonce==map_t.size()){//t里出现的所有不同字符的出现次数都满足
                if(res.equals("")) {
                    res = s.substring(left, right);
                }else{
                    res=((right-left)<res.length()?s.substring(left, right):res);
                }

                if(map_t.containsKey(s.charAt(left))&&map_t.get(s.charAt(left)).intValue()==map_window.get(s.charAt(left)).intValue()){
                        nonce--;
                }
                map_window.replace(s.charAt(left),map_window.get(s.charAt(left)).intValue()-1);//每当缩进一步left，就直接从滑窗里删除对应元素
                left++;
            }

        }
        return res;
    }
}
