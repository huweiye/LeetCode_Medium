package Hot100;

public class ProductExceptSelf {
    /*考察的是前缀与后缀*/
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] left=new int[n];//nums[i]左侧的元素之积,不包括nums[i]
        int [] right=new int[n];//nums[i]右侧元素之积,不包括nums[i]
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++)   left[i]=left[i-1]*nums[i-1];
        for(int i=n-2;i>=0;i--) right[i]=right[i+1]*nums[i+1];
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=left[i]*right[i];
        }
        return res;




    }
}
