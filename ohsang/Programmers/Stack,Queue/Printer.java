import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            int[] data = {i, priorities[i]};
            queue.add(data);
        }

        int cnt = 0;
        while (true) {
            int[] popData = queue.poll();
            boolean flag = false;
            for(var data : queue) {
                if(popData[1] < data[1]) {
                    queue.add(popData);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                cnt++;
                if(popData[0]==location)
                    break;
            }
        }

        return cnt;
    }

    public static void main(String args[]) {
        int[] priorities1 = {2,1,3,2};
        System.out.println(solution(priorities1, 2));
        int[] priorities2 = {1,1,9,1,1,1};
        System.out.println(solution(priorities2, 0));
    }
}