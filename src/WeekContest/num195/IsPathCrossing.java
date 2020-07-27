package WeekContest.num195;

import java.util.HashSet;
import java.util.Set;

public class IsPathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> points=new HashSet<>();
        points.add("00");
        int [] now_point=new int[2];
        for(int i=0;i<path.length();i++){
            switch (path.charAt(i)){
                case 'N':
                    now_point[1]+=1;
                    String temp=""+now_point[0]+now_point[1];
                    if(points.contains(temp)) return true;
                    points.add(temp);
                    break;
                case 'S':
                    now_point[1]-=1;
                    String temp1=""+now_point[0]+now_point[1];
                    if(points.contains(temp1)) return true;
                    points.add(temp1);
                    break;
                case 'W':
                    now_point[0]-=1;
                    String temp2=""+now_point[0]+now_point[1];
                    if(points.contains(temp2)) return true;
                    points.add(temp2);
                    break;
                case 'E':
                    now_point[0]+=1;
                    String temp3=""+now_point[0]+now_point[1];
                    if(points.contains(temp3)) return true;
                    points.add(temp3);
                    break;
            }

        }
        return false;


    }
}
