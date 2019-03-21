import java.util.Arrays;

public class Note190319 {
    private static int[] solution(int[] array, int[][] commands) {
        int answer_size = commands.length;
        int[] answer = new int[answer_size];
        int from, to, position;

        for(int i=0; i<answer_size; i++) {
            from = commands[i][0] - 1;
            to = commands[i][1];
            position = commands[i][2] - 1;

            int[] temp = Arrays.copyOfRange(array, from, to);
            Arrays.sort(temp);
            answer[i] = temp[position];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(array, commands);
    }
}
