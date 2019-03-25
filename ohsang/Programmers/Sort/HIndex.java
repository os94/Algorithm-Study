public class Test {

    public static int solution(int[] citations) {
        int answer = 0;
        bubbleSort(citations);

        for(int i=1; i<=citations.length; i++) {
            answer = Math.max(answer, Math.min(i, citations[i-1]));
        }

        return answer;
    }

    public static void bubbleSort(int[] arr) {
        for(int i=arr.length-2; i>=0; i--) {
            for(int k=0; k<=i; k++) {
                if(arr[k] < arr[k+1]) {
                    int tmp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tmp;
                }
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(solution(new int[]{3,0,6,1,5})); //3
        System.out.println(solution(new int[]{4,5,8,10,3})); //4
        System.out.println(solution(new int[]{25,2,5,3,8})); //3
    }
}