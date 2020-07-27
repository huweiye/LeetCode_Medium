package WeekContest.num31;

public class CountOdds {
    public int countOdds(int low, int high) {
        if(low==high) return low%2==0?0:1;
       if(low%2==0&&high%2==0) return (high-low-1)/2+1;
       else if(low%2!=0&&high%2!=0) return (high-low-1)/2+2;
       else return(high-low-1)/2;

    }
}
