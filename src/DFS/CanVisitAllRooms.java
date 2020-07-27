package DFS;

import java.util.List;

public class CanVisitAllRooms {
    public CanVisitAllRooms() {
        super();
    }
    int sum;
    List<List<Integer>> rooms;
    int n;
    boolean [] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms=rooms;
        n=rooms.size();//房间个数
        visited=new boolean[n];
        dfs(0);
        return sum==n;
    }
    private void dfs(int i){//dfs房间i
        if(visited[i]) return;
        sum++;
        visited[i]=true;
        for(int j=0;j<rooms.get(i).size();j++){
            dfs(rooms.get(i).get(j));
        }
    }

}
