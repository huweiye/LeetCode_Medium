package BinaryDivide;

public class FindBestValue {
    public FindBestValue() {
        super();
    }
    public int findBestValue(int[] arr, int target) {//待查找区间是所有可能的value从小到大排好的数组，要查的目标是能使距离更小的那个value的左边界
        int sum=0,max_arr=arr[0];
        for (int a: arr) {
            if(a>max_arr) max_arr=a;
            sum+=a;
        }
        if(sum<=target) return max_arr;//依题意改变arr，只会让sum(arr)不变或变得更小，当target本身就大于等于sum(arr)时，取arr的最大元素，不改变arr

        int left=0;//能取到的最小值,即待查找区间起始点
        int right=max_arr;//能取到的最大值，即待查找区间终结点，实际上更大也可以，但是没有意义，都不改变arr

        int mid=-1;
        while (left<=right){
            mid=(left+right)/2;
            int temp=get_sum(arr,mid);
            if(temp-target==0) return mid;
            else if(temp<target) left=mid+1;
            else right=mid-1;
        }
       if(Math.abs(get_sum(arr,left)-target)<Math.abs(get_sum(arr,left-1)-target)) return left;
       else return left-1;


    }
    public int get_sum(int [] arr,int value){//二分的判断函数，用于判断是否距离更小
        int sum=0;
        for (int a: arr) {
            if(a>value) sum+=value;
            else sum+=a;
        }
        return sum;
    }


}
