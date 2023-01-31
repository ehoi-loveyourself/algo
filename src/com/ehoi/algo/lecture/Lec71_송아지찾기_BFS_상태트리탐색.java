package com.ehoi.algo.lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec71_송아지찾기_BFS_상태트리탐색 {
    static int s, e;
    static int[] comm = {1, -1, 5};
    static int[] ans = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        e = sc.nextInt();
        ans[s] = 1; // 왔었다는 방문처리 임과 동시에 몇번째에 방문했는지를 알 수 있는 장치
        bfs(s);
        sc.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        outer:
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i : comm) {
                int res = curr + i;
                if (res == e) { // 도착했다면
                    System.out.println(ans[curr]); // 직전까지 몇번만에 왔는지를 출력해주면 됨 값이 +1 된 상태로 저장이 되어 있어서
                    break outer;
                }
                // res 자리에 온적이 없다면
                if (ans[res] == 0) {
                    // 왔다는 표시를 해야 하는데, 내가 이전에 갔던 자리에서 온 거니까 + 1
                    ans[res] = ans[curr] + 1;
                    // 그리고 res도 큐에 다시 넣어야지
                    queue.add(res);
                }
            }

        }
    }
}
