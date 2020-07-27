package SlidingWindowANDDoublePointer;

public class NumberOfSubarrays {
    public NumberOfSubarrays() {
        super();
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=0;
        int window_odd=0;//当前窗口的奇数的个数
        int res=0;
        while (right<n) {
            if (nums[right] % 2 != 0) {
                window_odd++;
                if (window_odd == k) {//当前窗口的奇数个数满k个了，而且窗口的right一定是奇数
                    //先从left统计到窗口的最左侧奇数之间一共有多少个偶数
                    int start_k = 1;//对于当前的窗口里包含的k个奇数，它能组成的子数组的可能的起始位置
                    while (nums[left] % 2 == 0) {//每一个偶数都是一个可能的起始位置
                        start_k++;
                        left++;
                    }
                    //再从right统计到下一个奇数之间有多少个偶数
                    int end_k = 1;//对于当前窗口包含的k个奇数，它能组成的子数组的可能的终点位置
                    right++;//right当前指向的是当前窗口的右边界，也是当前窗口包含的第k个奇数
                    window_odd--;
                    while (right < n && nums[right] % 2 == 0) {
                        end_k++;
                        right++;
                    }
                    res += start_k * end_k;
                    left++;
                }else{
                    right++;
                }
            }else{
                right++;
            }
        }
        return res;
    }
}
