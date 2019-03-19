public class Test {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] place = new int[truck_weights.length];

        int head = 0, next = 0, sum = 0;
        while (place[truck_weights.length - 1] < bridge_length) {
            answer++;

            if (place[head] == bridge_length) {
                sum -= truck_weights[head];
                place[head++]++;
            }

            if (next < truck_weights.length && sum + truck_weights[next] <= weight)
                sum += truck_weights[next++];

            for (int i = head; i < next; i++) {
                place[i]++;
            }

            // debugging code
            /*System.out.println("#"+answer);
            System.out.println("head,next:"+head+","+next);
            System.out.println("sum:"+sum);
            System.out.println("place:"+Arrays.toString(place));*/
        }

        return answer + 1; // +1 for last truck
    }

    public static void main(String args[]) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}