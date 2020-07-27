package Hot100;

public class SortColors {
    public void sortColors(int[] nums) {
        partition(nums,0,nums.length-1,1);
    }
    public void partition(int[] nums,int L,int R,int num){//划分成：左边都是小于num的，中间一些等于num的，右边都是大于num的
        int less=L-1;//初始的时候左区域为空
        int more=R+1;//初始的时候右区域为空
        int curr=L;
        while (curr<more){//要么是curr右移要么是more左移，O(n)
            if(nums[curr]<num) swap(nums,++less,curr++);//less的下一位和当前curr互换，相当于less扩展了一位，然后curr右移
            else if(nums[curr]>num) swap(nums,--more,curr);//more的靠左一位与当前curr互换，相当于more向左扩展了一位，curr位置不变，要继续考察被换过来的这个新数
            else curr++;//nums[curr]==num，无需和左右区域互换，直接考察下一位
        }
    }
    private void swap(int [] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
