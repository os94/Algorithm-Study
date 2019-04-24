import java.util.*;

public class Test {
    public static void main(String args[]) {
        System.out.println(solution("17")); // 3
        System.out.println(solution("011")); // 2
    }

    public static int solution(String numbers) {
        int n = numbers.length();
        Set<Integer> numberSet = new HashSet<>();
        int answer = 0;
        int[] arr = new int[n];
        boolean primeMap[];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        for (int k = 1; k <= n; k++) {
            permutation(numberSet, arr, 0, n, k);
        }

        primeMap = setPrimes(numberSet);
        for (int num : numberSet) {
            if (isPrime(primeMap, num)) {
                answer++;
            }
        }

        return answer;
    }

    // permutation algorithm
    public static void permutation(Set numberSet, int[] arr, int depth, int n, int k) {
        if (depth == k) {
            numberSet.add(parseInt(arr, k));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(numberSet, arr, depth + 1, n, k);
            swap(arr, depth, i);
        }
    }

    public static boolean[] setPrimes(Set<Integer> numberSet) {
        // get max of numberSet
        int max = 0;
        for (int num : numberSet) {
            if (num > max) max = num;
        }

        // set primeMap by 'Sieve of of Eratosthenes' algorithm
        boolean[] primeMap = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            primeMap[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (primeMap[i] == false) {
                continue;
            }
            for (int k = i + i; k <= max; k += i) {
                primeMap[k] = false;
            }
        }

        return primeMap;
    }

    public static boolean isPrime(boolean[] primeMap, int num) {
        if (primeMap[num]) {
            return true;
        }
        return false;
    }

    public static int parseInt(int[] arr, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append("" + arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
