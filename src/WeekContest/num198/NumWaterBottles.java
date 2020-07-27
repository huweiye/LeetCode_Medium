package WeekContest.num198;

public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res=0;
        res+=numBottles;//喝
        int now_bottles=numBottles;
        int now_jiu=0;//已经全喝了
        while (now_bottles>=numExchange) {//还能换
            now_jiu=now_bottles / numExchange;//换来的
            res+=now_jiu;//喝了
            now_bottles = (now_bottles % numExchange)+now_jiu;
        }
        return res;

    }
}
