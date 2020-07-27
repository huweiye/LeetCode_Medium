package Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmaller {
    /*原来的归并排序的算法是直接移动数组元素，现在需要定位排序之前元素的位置，所以merge算法中移动的是元素的下标，即索引数组元素
    merge时对索引数组的排序规则是不再是直接比较其元素大小，而是取对应位置处的num元素比较大小*/
    int [] res;
    public List<Integer> countSmaller(int[] nums) {
        this.res=new int[nums.length];
        int [] indexes=new int[nums.length];//索引数组，存储每个元素的下标
        for(int i=0;i<indexes.length;i++) indexes[i]=i;
        merge_sort(nums,indexes,0,indexes.length-1);//排的是索引数组
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
    private void merge_sort(int[] nums,int [] indexes,int left,int right){//排序移动的是索引数组的元素,排序规则是比较对应的nums元素
        if(left>=right) return;
        int mid=(left+right)/2;
        merge_sort(nums,indexes,left,mid);
        merge_sort(nums,indexes,mid+1,right);
        merge(nums,indexes,left,mid,right);
    }
    private void merge(int[] nums,int [] indexes,int left,int mid,int right){
        int [] help=new int[right-left+1];
        int i1=left;
        int i2=mid+1;
        int i=0;
        while (i1<=mid&&i2<=right){
            if(nums[indexes[i1]]>nums[indexes[i2]]){
                help[i]=indexes[i1];
                res[help[i]]+=(right-i2+1);
                i++;
                i1++;
            }
            else{
                help[i]=indexes[i2];
                i++;
                i2++;
            }
        }
        while (i1<=mid) help[i++]=indexes[i1++];
        while (i2<=right) help[i++]=indexes[i2++];

        for(int x=0;x<help.length;x++) indexes[left+x]=help[x];

    }
}
