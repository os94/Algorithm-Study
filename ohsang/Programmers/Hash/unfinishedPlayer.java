import java.util.*;

public class Test {
    public static void main(String args[]) {
        System.out.println(solution(new String[]{"123", "456", "789"}
                , new String[]{"123", "456"})); // 789
        System.out.println(solution(new String[]{"12", "34", "56", "78", "90"}
                , new String[]{"12", "56", "78", "90"})); // 34
        System.out.println(solution(new String[]{"12", "34", "56", "34"}
                , new String[]{"12", "34", "56"})); // 34
    }

    public static String solution(String[] participant, String[] completion) {
        List<String> part = Arrays.asList(participant);
        List<String> comp = Arrays.asList(completion);

        Collections.sort(part);
        Collections.sort(comp);

        for (int i = 0; i < comp.size(); i++) {
            if (!part.get(i).equals(comp.get(i))) {
                return part.get(i);
            }
        }
        return part.get(part.size() - 1);
    }
}
