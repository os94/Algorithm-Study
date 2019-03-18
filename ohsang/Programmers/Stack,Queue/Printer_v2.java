import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>(); // [2,1,3,2] 데이터가 en/de-queue되며 실제 돌아가는 큐
        for(int data : priorities)
            queue.add(data);

        Arrays.sort(priorities); // [1,2,2,3] 크기순정렬후 뒤에서부터읽어 1.가장큰건지 2.내가찾는건지 판단하는 기준으로 사용

        while (!queue.isEmpty()) {
            Integer data = queue.poll();
            if(data == priorities[priorities.length-1-answer]) {
                answer++;
                location--;
                if(location<0) break; // 가장커서 pop한게 내가 찾는 값이었다. break;
            } else {
                queue.add(data);
                location--;
                if(location<0) location=queue.size()-1; // 더큰값이 있어 다시 push되는데, 내가 찾는 값이었어서 location값 갱신
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        int[] priorities1 = {2,1,3,2};
        System.out.println(solution(priorities1, 2));
        int[] priorities2 = {1,1,9,1,1,1};
        System.out.println(solution(priorities2, 0));
    }
}