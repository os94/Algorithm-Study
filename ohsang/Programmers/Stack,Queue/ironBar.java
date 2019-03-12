import java.util.Stack;

public class Test {

    public static int solution(String arrangement) {
        int answer = 0;
        Stack myStack = new Stack();

        for(int i=0; i<arrangement.length()-1; ) {
            String cur = String.valueOf(arrangement.charAt(i));
            String next = String.valueOf(arrangement.charAt(i+1));

            if( cur.equals("(") && next.equals(")") ) {
                answer += myStack.size();
                i += 2;
            } else if ( cur.equals("(") ) {
                myStack.push(i);
                answer += 1;
                i++;
            } else if ( cur.equals(")") ) {
                myStack.pop();
                i++;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        String input = "()(((()())(())()))(())";
        int result = 0;

        result = solution(input);

        System.out.println("result: "+ result);
    }

}