package WeekContest.num193;

public class MinDays {
    public MinDays() {
        super();
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int left=bloomDay[0];
        int right=bloomDay[0];
        int n=bloomDay.length;
        for(int i=1;i<n;i++){
            left=Math.min(left,bloomDay[i]);
            right=Math.max(right,bloomDay[i]);
        }
        if(m*k>n) return -1;
        int mid=-1;
        int res=-1;
        while (left<=right){
            //开始二分
            mid=(left+right)/2;
            if(flower(bloomDay,mid,m,k)){
                right=mid-1;
                res=mid;
            }else{
                left=mid+1;
            }

        }
        return res;
    }
    private boolean flower(int[] bloomDay,int day,int m,int k){
        int can_get=0;
        int lianxu=0;
        for (int bloom:bloomDay) {
            if(bloom<=day){
                lianxu++;
            }else{
                lianxu=0;
                continue;
            }
            if(lianxu>=k){
                can_get++;
                lianxu=0;
                if(can_get>=m){
                    return true;
                }
            }
        }
        return can_get>=m;
    }
}
