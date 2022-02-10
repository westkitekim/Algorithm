package sorting;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class B2751_수정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        Integer[] nums = new Integer[testCase];//int가 아닌 Integer로 선언!!
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < testCase; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int a : nums) sb.append(a + "\n");
        System.out.println(sb);
    }
}
