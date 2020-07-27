package SlidingWindowANDDoublePointer;

public class LongestOnes {
    public LongestOnes() {
        super();
    }
    public int longestOnes(int[] A, int K) {
        int n=A.length;
        int window_zero=0;//当前窗口0的个数
        int left=0,right=0;
        int res=0;
        while (right<n){
            if(A[right]==0) window_zero++;
            if(K>=window_zero){
                res=Math.max(res,(right-left+1));
            }
            else{
                if(A[left]==0) window_zero--;
                left++;
            }
            right++;
        }
        return res;

    }
}
