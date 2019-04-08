import java.util.*;

public class Test {
    public static int solution(int[][] baseball) {
        int answer = 0;

        for (int flag = 0, n = 123; n < 1000; n++) {
            if (checkZero(n) || checkduplicate(n)) {
                continue;
            }

            for (int j = 0; j < baseball.length; j++) {
                if (!matchStrikeBall(n, baseball[j])) {
                    break;
                }
                flag++;
            }

            if (flag == baseball.length) {
                answer++;
            }
            flag = 0;
        }

        return answer;
    }

    public static boolean matchStrikeBall(int n, int[] input) {
        Integer[] nArr = new Integer[3];
        Integer[] inArr = new Integer[3];
        int strike = 0;
        int ball = 0;

        getDigit(n, nArr);
        getDigit(input[0], inArr);

        for (int i = 0; i < 3; i++) {
            if (nArr[i] == inArr[i]) {
                strike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (Arrays.asList(nArr).contains(inArr[i])) {
                ball++;
            }
        }
        ball -= strike;

        if (strike == input[1] && ball == input[2]) {
            return true;
        }
        return false;
    }

    public static void getDigit(int number, Integer[] digitArr) {
        digitArr[0] = number / 100;
        digitArr[1] = (number / 10) % 10;
        digitArr[2] = number % 10;
    }

    public static boolean checkZero(int n) {
        String numStr = Integer.toString(n);
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkduplicate(int n) {
        String numStr = Integer.toString(n);
        ArrayList<Character> numList = new ArrayList<>();
        HashSet<Character> numSet = new HashSet<>();

        for (int i = 0; i < numStr.length(); i++) {
            numList.add(numStr.charAt(i));
            numSet.add(numStr.charAt(i));
        }

        if (numList.size() == numSet.size()) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[][]{
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}
        })); //2
    }
}
