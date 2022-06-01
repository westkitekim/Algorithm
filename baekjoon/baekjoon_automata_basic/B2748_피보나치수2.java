package baekjoon_automata_basic;

import java.util.Scanner;

public class B2748_피보나치수2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(fibonacciNums(N));
    }

    public static long fibonacciNums(int number) {
        // 정수 범위 초과로 int 형이 아닌 long type으로 정의해야한다. 반례> 90
        long[] arr = new long[number + 1]; // ArrayIndexOfBoundException 주의
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < number + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[number];
    }
}


