package do_it_basic.ex_chap02;

import java.util.Random;
import java.util.Scanner;

/**
 *  Do it 알고리즘[자바]
 *  - [실습 2-5]
 *  - 난수 사용해 배열의 요솟값 설정하기
 *  - Random Class 이용한 난수 생성
 */
public class Ex5_난수배열생성 {

    // 배열의 최대값 구하기
    static int randArrMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) { // arr[0] 동일 값 비교 들어감
            if(num > max) max = num;
        }

        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("난수의 최대값을 구합니다.");
        System.out.print("배열의 크기 : ");
        int arrSize = in.nextInt(); // 배열의 크기 지정

        int[] array = new int[arrSize]; // 입력받은 크기의 배열 생성

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(2000); // nextInt(n) : 0 - n-1 까지의 난수 반환
            System.out.println("array[" + i + "] = " + array[i]);
        }

        System.out.println("배열 array의 최대값은 " + randArrMax(array) + "입니다.");
    }
}
