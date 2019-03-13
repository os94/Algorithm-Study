import java.util.Arrays;

public class Test {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int m=0; m<commands.length; m++) {
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];

            int[] array2 = new int[j-i+1];
            System.arraycopy(array, i-1, array2, 0, j-i+1);

            //Bubble Sort
            /*for(int x=array2.length-1; x>=0; x--) {
                for(int y=0; y<x; y++) {
                    if(array2[y]>array2[y+1]) {
                        int tmp = array2[y];
                        array2[y] = array2[y+1];
                        array2[y+1] = tmp;
                    }
                }
            }*/
            Arrays.sort(array2);

            answer[m] = array2[k-1];
        }

        return answer;
    }

    public static void main(String args[]) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] result;

        result = solution(array, commands);

        System.out.println("result: "+ Arrays.toString(result));
    }

}