package WeekContest.past;

import java.util.Arrays;

public class MaxArea {
    public MaxArea() {
        super();
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m=horizontalCuts.length;
        int n=verticalCuts.length;
        long max_height=horizontalCuts[0];
        long max_width=verticalCuts[0];
        for(int i=1;i<m;i++){
             max_height=Math.max(max_height,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i=1;i<n;i++){
             max_width=Math.max(max_width,verticalCuts[i]-verticalCuts[i-1]);
        }
         max_height=Math.max(max_height,h-horizontalCuts[m-1]);
         max_width=Math.max(max_width,w-verticalCuts[n-1]);

        return (int)((max_height*max_width)%(1000000007));

    }
}
