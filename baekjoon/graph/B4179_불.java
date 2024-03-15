package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179_불 {
    private static int r, c;
    private static char[][] maze;
    private static int[][] timeFire;
    private static int[][] timePerson;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Node> queFire;
    private static Queue<Node> quePerson;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        init();

        bfsFire();
        bfsPerson();

        if (!quePerson.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static void bfsPerson() {
        while (!quePerson.isEmpty()) {
            Node now = quePerson.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 탈출 완료
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(timePerson[now.x][now.y] + 1);
                    return;
                }
                if (timePerson[nx][ny] >= 0 || maze[nx][ny] == '#') {
                    continue;
                }
                // 진행X 조건 : 지훈 도달 시간 >= 불 도달 시간
                // 틀린 원인 : && timeFire[nx][ny] != -1 추가해야함, 초기값 제어
                if (timePerson[now.x][now.y] + 1 >= timeFire[nx][ny] && timeFire[nx][ny] != -1) {
                    continue;
                }
                timePerson[nx][ny] = timePerson[now.x][now.y] + 1;
                quePerson.offer(new Node(nx, ny));
            }
        }
    }

    private static void bfsFire() {
        while (!queFire.isEmpty()) {
            Node now = queFire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (timeFire[nx][ny] >= 0 || maze[nx][ny] == '#') {
                    continue;
                }
                timeFire[nx][ny] = timeFire[now.x][now.y] + 1;
                queFire.offer(new Node(nx, ny));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        maze = new char[r][c];
        timeFire = new int[r][c];
        timePerson = new int[r][c];
        queFire = new LinkedList<>();
        quePerson = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            char[] ch = st.nextToken().toCharArray();
            for (int j = 0; j < c; j++) {

                maze[i][j] = ch[j];
                timeFire[i][j] = -1;
                timePerson[i][j] = -1;

                if ('F' == maze[i][j]) { // 불의 초기 좌표
                    queFire.offer(new Node(i, j));
                    timeFire[i][j] = 0;
                }

                if ('J' == maze[i][j]) { // 지훈 초기 좌표
                    quePerson.offer(new Node(i, j));
                    timePerson[i][j] = 0;
                }
            }
        }
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
