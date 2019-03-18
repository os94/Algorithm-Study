import java.util.*;

public class Test {

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> progress = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> release = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) { // init
            progress.add(progresses[i]);
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cnt = 0;
            for(int i=0; i<progress.size(); i++) { // update
                progress.set(i, progress.get(i)+speeds[i]);
            }
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++) { // check for release
                if(progress.get(queue.peek()) >= 100) {
                    queue.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt != 0)
                release.add(cnt);
        }

        int[] answer = release.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String args[]) {
        int[] progress = {93,30,55};
        int[] speed = {1,30,5};
        System.out.println(Arrays.toString(solution(progress, speed)));

    }
}