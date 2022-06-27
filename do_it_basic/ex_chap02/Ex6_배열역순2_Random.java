package do_it_basic.ex_chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ex6_배열역순정렬 {

    // 배열 값 바꾸기
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1]; arr[idx1] = arr[idx2]; arr[idx2] = temp;
    }

    // 배열 역순으로 switch
    static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i); // arr.length - 1 = 베열의 마지막 index
                                                   // 에서 i 감산
        }
    }

    public static void main(String[] args) throws IOException {

        Random rand = new Random();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrLen = Integer.parseInt(br.readLine());
        System.out.println("배열의 요솟수 : " + arrLen);

        int[] arr = new int[arrLen];

        // 난수 배열 생성
        for (int i = 0; i < arrLen; i++) {
            arr[i] = rand.nextInt(1000); // 0 ~ 999까지의 난수 할당
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        reverse(arr);

        System.out.println("arr 배열 역순 정렬 완료");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
