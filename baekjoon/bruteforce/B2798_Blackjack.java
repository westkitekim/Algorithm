package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ���� nCr ? n! / (n-r)!
 * ���� �ƴ� ����.. ������ ���� �ִ밪 ���ϱ�
 */
public class B2798_Blackjack {
	public static int maxSum(int[] arr, int M) {
		int N = arr.length;
		int max = 0;
		//3�� �����̱� ������ ù��° for���� ������ 2���� ���� �� �ͱ��� loop 
		//j�� k�� 1, 2 ���� ������ �ƴ϶� i���� ���ϱ� - j, k ��� ���۰��� ���� loop ���۰��� +1 
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {// ���⼭ Ʋ���� - i + 2�� �ƴ� j + 1(����������)
					//M�� ���� �ʴ� ���� �ԷµǱ� ������ �ִ밪 �ݵ�� ����
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
		//�ι� ° �Է¶���
		//StringTokenizer ��ü ���� ����
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = maxSum(arr, M);
		System.out.println(sum);
	}
}
