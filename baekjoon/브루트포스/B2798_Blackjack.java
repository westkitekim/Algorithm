package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 조합 nCr ? n! / (n-r)!
 * 조합 아님 주의.. 각각의 조합 최대값 구하기
 */
public class B2798_Blackjack {
	public static int maxSum(int[] arr, int M) {
		int N = arr.length;
		int max = 0;
		//3개 선택이기 때문에 첫번째 for문을 제외한 2개의 값을 뺀 것까지 loop 
		//j와 k는 1, 2 부터 시작이 아니라 i값에 더하기 - j, k 모두 시작값은 이전 loop 시작값에 +1 
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {// 여기서 틀렸음 - i + 2가 아닌 j + 1(순차적으로)
					//M을 넘지 않는 값이 입력되기 때문에 최대값 반드시 존재
					int total = arr[i] + arr[j] + arr[k];
                    
					if(total <= M && total >= max) max = total;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		//두번 째 입력라인
		//StringTokenizer 객체 새로 생성
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = maxSum(arr, M);
		System.out.println(sum);
	}
}
