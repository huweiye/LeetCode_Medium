package SlidingWindowANDDoublePointer;

public class SumSubarrayMins {

    public int sumSubarrayMins(int[] A) {
        int n=A.length;
        long res=0L;
        for(int left=0;left<n;left++){//窗口的左边界
            int min_window=A[left];//重置窗口最值
            for(int right=left;right<n;right++){
                min_window=Math.min(min_window,A[right]);//只往当前窗口添加元素的情况下，求最值只需要一次比较
                res+=min_window;
            }

        }
        return (int)(res%(1000000000+7));

    }


}
