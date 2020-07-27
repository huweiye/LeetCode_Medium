package WeekContest.num29;

import java.util.HashMap;

public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        int max_len=0;
        HashMap<Integer,Integer> windows=new HashMap<>();
        windows.put(0,-1);
        while (right<n){
            if(nums[right]==1){
                max_len=Math.max(max_len,right-left);
                right++;
                continue;
            }
            if(nums[right]==0){
                if(windows.get(0)==-1){
                    windows.replace(0,right);
                }else if(windows.get(0)==left){
                    max_len=Math.max(max_len,right-left-1);
                    left=windows.get(0);
                    while (left<right&&nums[left]==0) left++;
                    if(left==n) return max_len;
                    windows.replace(0,right);
                }else if(windows.get(0)==right-1){
                    max_len=Math.max(max_len,right-left-1);
                    left=windows.get(0);
                    while (left<right&&nums[left]==0) left++;
                    if(left==n) return max_len;
                    windows.replace(0,right);
                }else{
                    max_len=Math.max(max_len,right-left-1-1);
                    left=windows.get(0);
                    while (left<right&&nums[left]==0) left++;
                    if(left==n) return max_len;
                    windows.replace(0,right);
                }
                right++;
            }

        }
        return max_len;


    }
}
