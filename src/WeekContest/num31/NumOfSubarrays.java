package WeekContest.num31;

public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr) {
        long res=0L;
        int n=arr.length;
        int [] p=new int[n+1];
        p[0]=0;
        for(int i=1;i<p.length;i++) p[i]=arr[i-1]+p[i-1];

        for(int i=1;i<p.length;i++){
            for(int j=i;j<p.length;j++){
                if((p[j]-p[i-1])%2!=0) res++;
            }
        }
        return (int)(res%((long)(1000000000+7)));


        /*int n=arr.length;
        *//*奇数+奇数=偶数；
        奇数+偶数=奇数；
        偶数+偶数=偶数
        * *//*
        long res=0L;
        int left=0;
        int right=0;
        int win_sum=0;
        while (right<n){
            win_sum+=arr[right];
            while (win_sum%2!=0&&left<=right){
                res++;
                win_sum-=arr[left];
                left++;
            }
            if(left>right) right=left;
            else right++;
        }
        return (int)(res%((long)(1000000000+7)));
*/

    }
}
