import java.util.*;

public class Test {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> truckStack = new Stack<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        for (int i = truck_weights.length - 1; i >= 0; i--)
            truckStack.push(truck_weights[i]);

        int answer = 0;
        int sum = 0;
        while (true) {
            answer++;

            if (bridgeMap.containsKey(answer))
                bridgeMap.remove(answer);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if (!truckStack.isEmpty())
                if (sum + truckStack.peek() <= weight)
                    bridgeMap.put(answer + bridge_length, truckStack.pop());

            if (bridgeMap.isEmpty() && truckStack.isEmpty())
                break;
        }

        return answer;
    }

    public static void main(String args[]) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}