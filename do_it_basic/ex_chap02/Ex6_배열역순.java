package do_it_basic.ex_chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Do it 알고리즘[자바]
 *  - [실습 2-6]
 *  - 배열 역순 정렬
 *  - swap, reverse
 */
public class Ex6_배열역순 {

    static void swap(int[] a,int idx1, int idx2 ) {
        int temp = a[idx1]; a[idx1] = a[idx2]; a[idx2] = temp;
    }

    static void reverse(int[] arr) {
        // arr.length 전체 loop 돌 필요없음 -> 1/2만 swap하면 됨
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1); // 배열은 0부터 시작하여 최대 index가 arr.length - 1 이므로 여기서 - i 한다.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        System.out.println("배열의 길이 : " + len);

        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        reverse(arr);

        System.out.println("배열 요소 역순 정렬 완료");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
