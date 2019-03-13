public class Test {
    public static int solution(int[] numbers, int target) {
        return DFS(numbers, target, 0, 0);
    }

    public static int DFS(int[] numbers, int target, int idx, int sum) {
        if(idx == numbers.length) {
            return sum == target ? 1 : 0;
        } else {
            return DFS(numbers, target, idx+1, sum+numbers[idx])
                    + DFS(numbers, target, idx+1, sum-numbers[idx]);
        }
    }

    public static void main(String args[]) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int result;

        result = solution(numbers, target);

        System.out.println("result: "+ result);
    }
}