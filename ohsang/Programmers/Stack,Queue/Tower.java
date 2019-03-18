import java.util.Arrays;

public class Test {

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i=1; i<heights.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(heights[j] > heights[i]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        int[] height1 = {6,9,5,7,4};
        System.out.println(Arrays.toString(solution(height1)));
        int[] height2 = {3,9,9,3,5,7,2};
        System.out.println(Arrays.toString(solution(height2)));
        int[] height3 = {1,5,3,6,7,6,5};
        System.out.println(Arrays.toString(solution(height3)));
    }
}