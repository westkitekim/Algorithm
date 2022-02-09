package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1181_단어정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] word = new String[n];

        /**
         * nextInt() 정수 입력 후 nextLine() 사용 시
         * 첫 번째 입력값이 word[0]에 저장되는 것이 아니라
         * "\n" 개행이 저장됨. next계열 입력 받은 후 nextLine()을 사용하면
         * 두 메서드의 메커니즘이 달라 발생하는 대표적인 에러,
         *
         * nextLine()을 먼저 작성하여 개행 버린다음 데이터 할당
         */
        sc.nextLine();//맨 처음 개행 버리기

        for (int i = 0; i < n; i++) {
            word[i] = sc.nextLine();
        }

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    //길이 같을경우 사전순으로
                    return o1.compareTo(o2);
                    //그 외는 길이순으로 오름차순
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

/*      마지막 인덱스 출력 X
        for(int i = 0; i < n; i++) {
            if(i < n - 1 && !word[i].equals(word[i + 1])) {
                    System.out.println(word[i]);
            }
        }

 */
        //첫 번째 값은 중복이 안되기 때문에 먼저 출력
        System.out.println(word[0]);

        for (int i = 1; i < n; i++) {
            if(!word[i].equals(word[i - 1])) {
                System.out.println(word[i]);
            }
        }
    }
}
