package BinaryDivide;

public class HIndex {
    public HIndex() {
        super();
    }
    public int hIndex(int[] citations) {
        int right=citations.length;//h指数可能的最大值，即发表的论文个数
        int left=0;//h指数可能的最小值
        //对任意可能的h指数mid，查找所有满足条件的mid的最大值（区间右边界）
        //条件指的是H指数的定义：所有论文中共有 mid 篇论文分别被引用了至少 mid次
        //之所以查右边界是因为如果 h 有多有种可能的值 ，h 指数是其中最大的那个
        int mid=-1;
        int res=0;
        while (left<=right){//开始二分找右边界
            mid=(left+right)/2;
            if(is_a_Hindex(citations,mid)){left=mid+1;res=mid;}//mid是一个h指数，缩小到右区间看看还能不能更大
            else right=mid-1;
        }
        return res;
    }
    public boolean is_a_Hindex(int[] citations,int h_index){//用二分地办法判断h_index是不是一个h指数
        //查第一个大于等于mid的citations元素的下标，即区间左边界
        int n=citations.length;
        int left=0;
        int right=n-1;
        int target=-1;
        int mid=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(citations[mid]>=h_index){right=mid-1;target=mid;}//查找满足条件的最小值，所以缩小到左半区间
            else{left=mid+1;}//不满足条件，到更大的右半区间查找
        }
        if(target!=-1&&(n-target)>=h_index) return true;//(n-target)是被引用了至少h_index次的论文的数目，只有它大于等于h_index，说明h_index可以作为一个h指数
        else return false;
    }

}
