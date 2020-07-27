package Hot100;

public class FindKthLargest {
    int max_k;
    int k;
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==1) return nums[0];
        this.k=k;
        merge_sort(nums,0,nums.length-1);
        return max_k;
    }
    public void merge_sort(int [] nums,int left,int right){
        if(left==right) return;
        int mid=(left+right)/2;
        merge_sort(nums,left,mid);
        merge_sort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public void merge(int [] nums,int left,int mid,int right){
        int [] help=new int[right-left+1];
        int i=0;
        int i1=left;
        int i2=mid+1;
        while (i1<=mid&&i2<=right) help[i++]=nums[i1]>nums[i2]?nums[i1++]:nums[i2++];
        while (i1<=mid) help[i++]=nums[i1++];
        while (i2<=right) help[i++]=nums[i2++];
        for (int x=0;x<help.length;x++){
            if(x+1==k) max_k=help[x];
            nums[left+x]=help[x];
        }
    }
}
