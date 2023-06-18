package baekjoon.linear;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B10866_덱 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String input = sc.next(); // 공백전만 할당

            switch (input) {
                case "push_front": {
                    deque.addFirst(sc.nextInt());
                    break;
                }
                case "push_back": {
                    deque.addLast(sc.nextInt());
                    break;
                }
                case "pop_front": {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.removeFirst()).append("\n");
                    break;
                }
                case "pop_back": {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.removeLast()).append("\n");
                    break;
                }
                case "size": {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case "empty": {
                    if (deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                }
                case "front": {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else  sb.append(deque.peekFirst()).append("\n");
                    break;
                }
                case "back": {
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else  sb.append(deque.peekLast()).append("\n");
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
