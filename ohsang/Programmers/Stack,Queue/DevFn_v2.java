import java.util.*;

public class Test {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int day = 0;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (speeds[i]*day) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }
        return Arrays.stream(dayOfEnd).filter(i -> i!=0).toArray();
    }

    public static void main(String args[]) {
        int[] progress = {93,30,55};
        int[] speed = {1,30,5};
        System.out.println(Arrays.toString(solution(progress, speed)));
    }
}