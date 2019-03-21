import java.util.Scanner;

public class Bj2947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lst = new int[5];
        int tmp, s;

        while(true) {
            for(int i=0; i<lst.length; i++)
                lst[i] = sc.nextInt();

            s = checkStatement(lst);

            if(s == 0)
                break;
            else if(s == 1)
                System.out.println("1 2 3 4 5의 순서로 입력할 수 없습니다.");
            else if(s == 2)
                System.out.println("1~5 사이의 숫자만 입력하세요.");
            else if(s == 3)
                System.out.println("서로 중복된 숫자는 입력할 수 없습니다.");
            else
                return;
        }

        for(int i=0; i<(lst.length - 1); i++) {
            for(int j=0; j<(lst.length - i - 1); j++) {
                if(lst[j] > lst[j + 1]) {
                    tmp = lst[j];
                    lst[j] = lst[j+1];
                    lst[j+1] = tmp;

                    for(int element: lst)
                        System.out.print(element + " ");
                    System.out.println();
                }
            }
        }
    }

    private static int checkStatement(int[] lst) {
        if(lst[0] == 1 && lst[1] == 2 && lst[2] == 3 && lst[3] == 4 && lst[4] == 5) return 1;

        for(int element: lst)
            if(element < 1 || element > 5) return 2;

        for(int i = 0; i < lst.length - 1; i++)
            for(int j=i + 1; j < lst.length; j++)
                if(lst[i] == lst[j])
                    return 3;

        return 0;
    }
}
