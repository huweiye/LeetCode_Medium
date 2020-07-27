package SlidingWindowANDDoublePointer;

public class RemoveDuplicates {
    public RemoveDuplicates() {
        super();
    }
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int left=0,right=1;
        int res=n;
        while (right<res){
            if(nums[left]!=nums[right]){
                left++;
                right++;
            }else{//扩展窗口右边界看看该元素是否重复出现了两次以上
                int temp=right;
                right++;
                while (right<res&&nums[right]==nums[left]){//[1,1,1,2]....此时right指向第三个1
                    right++;
                }//退出该while时，right指向整体需要往前移动的首个元素，如上例中的2
                if(right==res) {//如[1,1,1,1],此时right超了，right=4;temp=1。直接返回新数组长度
                    res-=(right-temp-1);
                    break;
                }
                //right没有超，需要一个个地移动数组元素
                res-=(right-temp-1);
                move_arr(nums,right,temp+1);
                right=temp+1;
                left++;
            }

            }
            return res;
        }
        private void move_arr(int [] nums,int from,int to){//把from处的元素移到to处，后续的依次
            for (int i=from;i<nums.length;i++){
                nums[to]=nums[i];
                to++;
            }
    }
}
