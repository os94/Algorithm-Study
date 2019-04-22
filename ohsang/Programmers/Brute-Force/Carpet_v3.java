import java.util.*;

public class Test {
    public static int[] solution(int brown, int red) {
        int a = (brown + 4) / 2;
        int b = brown + red;
        // answer은 x^2-ax+b=0 이차방정식의 해(근의공식)
        int[] answer = {(int) (a + Math.sqrt(a * a - 4 * b)) / 2 // 가로
                , (int) (a - Math.sqrt(a * a - 4 * b)) / 2};     // 세로
        return answer;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(solution(10, 2))); // 4,3
        System.out.println(Arrays.toString(solution(8, 1))); // 3,3
        System.out.println(Arrays.toString(solution(24, 24))); // 8,6
    }
}
