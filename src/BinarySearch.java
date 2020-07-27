

public class BinarySearch {
    public BinarySearch() {
        super();
    }

    public int binary_search(int[] nums, int left, int right, int target){
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(target==nums[mid]) return mid;
        else if(target<nums[mid]) return binary_search(nums,left,mid-1,target);
        else return binary_search(nums,mid+1,right,target);
    }
}
