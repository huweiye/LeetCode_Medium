package WeekContest.num197;

public class NumSub {
    public int numSub(String s) {
        long res=0L;
        int n=s.length();
        int left=0;
        while (left<n&&s.charAt(left)=='0') left++;
        if(left==n) return 0;
        int right=left;//有‘1’
        while (right<n){
            if(s.charAt(right)=='1'){
                right++;
                if(right==n){
                    res=res+a_one_sub(left,n-1);
                    break;
                }
            }else{
                res=res+a_one_sub(left,right-1);
                left=right;
                while (left<n&&s.charAt(left)=='0'){
                   left++;
                }
                if(left==n) break;
                else right=left;
            }
        }
        return (int)(res%(long)(1000000000+7));

    }
    private long a_one_sub(int start,int right){
        long n=(long)(right-start+1);
        return ((n*(n+(long)1))/(long)2);
    }
}
