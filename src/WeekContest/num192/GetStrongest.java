package WeekContest.num192;

import java.util.ArrayList;
import java.util.Arrays;

public class GetStrongest {
    public GetStrongest() {
        super();
    }
    public int[] getStrongest(int[] arr, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        int mid_number=arr[((n - 1) / 2)];
        int left=0;//左指针
        int right=n-1;//右指针
        while (res.size()<k){
            if(Math.abs(mid_number-arr[left])>Math.abs(mid_number-arr[right])){
                res.add(arr[left]);
                left++;
            }else if(Math.abs(mid_number-arr[left])<=Math.abs(mid_number-arr[right])){
                res.add(arr[right]);
                right--;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

}
