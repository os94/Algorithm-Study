import java.util.*;

public class Test {
    public static int[] solution(int brown, int red) {
        for (int height = 1; height <= red; height++) {
            int width = red / height;
            int brownArea = (width + height) * 2 + 4;
            if (red % width == 0 && brownArea == brown) {
                return new int[]{width + 2, height + 2};
            }
        }
        return null;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(solution(10, 2))); // 4,3
        System.out.println(Arrays.toString(solution(8, 1))); // 3,3
        System.out.println(Arrays.toString(solution(24, 24))); // 8,6
    }
}
