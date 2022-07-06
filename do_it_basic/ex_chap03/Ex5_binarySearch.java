package do_it_basic.ex_chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_binarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = in.nextInt();
        int[] arr = new int[num];

        System.out.println("오름차순 입력");

        System.out.println("arr : ");
        arr[0] = in.nextInt();

        for (int i = 0; i < num; i++) {
            do {
                System.out.println("arr[" + i + "] : ");
                arr[i] = in.nextInt();
            } while (arr[i] < arr[i - 1]);  // 바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.println("검색할 값 : ");
        int ky = in.nextInt();

        int idx = Arrays.binarySearch(arr, ky); // 배열 arr에서 키 값이 ky인 요소 검색

        if (idx < 0) System.out.println("해당 값의 요소가 없습니다");
        else System.out.println(arr + "은(는) arr[" + idx + "] 에 있습니다.");
    }
}
