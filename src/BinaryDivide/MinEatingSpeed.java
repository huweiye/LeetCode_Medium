package BinaryDivide;


public class MinEatingSpeed {
    public MinEatingSpeed() {
        super();
    }
    public int minEatingSpeed(int[] piles, int H) {
        int n=piles.length;
        int max_pile=piles[0];
        for (int p: piles) if(p>max_pile) max_pile=p;

        int left=1;//待查找区间起始点，无穷的时间里，以最慢的速度吃香蕉，不过因为K为整数，所以取1
        int right=max_pile;//待查找区间终点，最少的时间H=piles.length，所以一小时吃完一堆
        int mid=-1;
        int res=-1;
        while (left<=right){
            //开始二分
            mid=(left+right)/2;
            if(eat_over_or_not(piles,H,mid)) {right=mid-1;res=mid;}//要找的是“能吃完”的所有速度的最小值，即它们的左边界
            else left=mid+1;
        }
        return res;//res为最后一个满足条件的mid



    }
    public boolean eat_over_or_not(int []piles,int H,int speed){
        //以speed的速度吃香蕉，判断一下能不能在H内吃完
        int sum=0;
        for (int p: piles) {
            sum += (p % speed == 0 ? p / speed : p / speed + 1);
            if(sum>H) return false;
        }
        return true;
    }

}
