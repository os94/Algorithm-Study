import java.util.*;

public class Test {

    public static String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        StringBuffer strBuf = new StringBuffer();

        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]+"");
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1) ) {
                    return -1;
                } else if( Integer.parseInt(o1+o2) < Integer.parseInt(o2+o1) )
                    return 1;
                else
                    return 0;
            }
        });

        for(int i=0; i<list.size(); i++) {
            strBuf.append(list.get(i));
        }

        answer = strBuf.toString();
        for(int i=0; i<answer.length(); i++) {
            if(answer.charAt(i) != '0') {
                return answer;
            }
        }
        return "0";
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[]{6,10,2})); //6210
        System.out.println(solution(new int[]{3,30,34,5,9})); //9534330
        // more testcase needed ..
    }
}