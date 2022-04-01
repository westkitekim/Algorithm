package do_it_basic.ex_chap06;

import java.util.Scanner;
//배열 분할
public class Partition {

    // left, right swqp 하는 메소드
    // 배열, left index, right index
    static void swap(int[] a, int pl, int pr) {
        int tempArrVal = a[pl];
        a[pl] = a[pr];
        a[pr] = tempArrVal;
    }

    static void partition(int[] a, int n) {
        int pl = 0;
        int pr = n - 1;
        int pivot = a[n / 2]; // pivot = 배열의 중간값으로 설정

        do {
            while (a[pl] < pivot) pl++;
            while (a[pr] > pivot) pr--;
            if(pl <= pr) swap(a, pl++, pr--);
        }while (pl <= pr);

        System.out.println("피벗의 값은 " + pivot + "입니다.");

        // left
        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // pivot 값
        if (pl > pr + 1) {
            System.out.println("피벗과 일치하는 그룹");
            for (int i = pr + 1; i <= pl - 1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        // right
        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("<배열 분할 예제>");
        System.out.print("배열 요솟수 : ");
        int elm = scan.nextInt();
        int[] eArr = new int[elm];

        for (int i = 0; i < elm; i++) {
            System.out.print("x[" + i + "] :");
            eArr[i] = scan.nextInt(); // 배열 처음부터 입력값 할당
        }

        // 분할 메서드 partition 호출
        partition(eArr, elm);

    }
}
