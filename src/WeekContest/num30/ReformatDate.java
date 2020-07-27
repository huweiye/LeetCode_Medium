package WeekContest.num30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ReformatDate {
    public String reformatDate(String date) {
        String [] date_arr=date.split(" ");
        String res=date_arr[2]+"-";
        HashMap<String,Integer> month_hashmap=new HashMap<>();
        String [] month=new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i=1;i<=12;i++) month_hashmap.put(month[i-1],i);
        int m=month_hashmap.get(date_arr[1]);
        String m_str=String.valueOf(m);
        if(m<=9) m_str="0"+m_str;
        res+=(m_str+"-");
        String day_str=date_arr[0].substring(0,date_arr[0].length()-2);
        if(day_str.length()==1) day_str="0"+day_str;
        res+=day_str;
        return res;

    }
}
