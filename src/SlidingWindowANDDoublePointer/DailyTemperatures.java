package SlidingWindowANDDoublePointer;

public class DailyTemperatures {
    public DailyTemperatures() {
        super();
    }
    public int[] dailyTemperatures(int[] T) {
        int n=T.length;
        int[] res=new int[n];
        //双指针
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(T[j]>T[i]){
                    res[i]=(j-i);
                    break;
                }
            }
        }
        return  res;
    }
}
