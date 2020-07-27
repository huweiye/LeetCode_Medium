package other.prefixSum;

public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res=0;
        int n=arr.length;
        int [] prefix_sum=new int[n+1];
        prefix_sum[0]=0;
        for(int i=1;i<n+1;i++) prefix_sum[i]=prefix_sum[i-1]+arr[i-1];

        for(int i=0;i<(n-k+1);i++){//子数组可能的起点
            if(((prefix_sum[i+k]-prefix_sum[i])/k)>=threshold) res++;
        }
        return res;

    }
}
