package Design;

import java.util.ArrayList;
import java.util.HashMap;


class TimeMap {
    HashMap<String,ArrayList<Integer>> key_indexs=new HashMap<>();//一个key对应一个链表，该链表存的是所有该key的timestamp
    HashMap<Integer,String> time_value=new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        time_value.put(timestamp,value);//更新time-value
        if(key_indexs.containsKey(key)){
            ArrayList<Integer> temp=key_indexs.get(key);
            temp.add(timestamp);
        }else{
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(timestamp);
            key_indexs.put(key,temp);
        }
    }

    public String get(String key, int timestamp) {
        int temp=get_index(timestamp,key);
        if(temp==-1) return "";
        return time_value.get(key_indexs.get(key).get(temp));

    }
    private int get_index(int timestamp,String key){//二分的办法查找timestamps里满足<=timestamp的最大值（右边界）
        ArrayList<Integer> timesList=key_indexs.getOrDefault(key,null);
        if(timesList==null) return -1;
        int left=0;
        int right=timesList.size()-1;
        int mid=-1,res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(timesList.get(mid)<=timestamp){res=mid;left=mid+1;}//满足条件，缩小到右半区域继续查找
            else right=mid-1;
        }
        return res;


    }
}
