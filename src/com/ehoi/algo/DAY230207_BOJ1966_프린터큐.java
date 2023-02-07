package com.ehoi.algo;

import java.io.*;
import java.util.*;

public class DAY230207_BOJ1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            } // 입력 끝

            int cnt = 0;
            outer:
            while (!q.isEmpty()) {
                int[] curr = q.poll();

                // 현재 curr의 중요도가 최고인지 알기 위해서 큐 내부에 있는 작업의 중요도와 비교해봐야 한다
                for (int i = 0; i < q.size(); i++) {
                    // 이때 큐를 LinkedList가 아니라 Queue 로 구현하면 get() 메서드를 사용할 수 없다고 한다
                    /*
                     * 중요도를 비교할 때 가장 중요도가 높은 작업을 찾는 것이 아니라
                     * 지금 내가 뽑힐 자격이 있는지만 판단하면 되는 것이므로
                     * 나보다 중요도가 높은 작업이 있기만 하면 그 작업 뒤로만 모두 가면 되는 것이지
                     * 그 작업이 가장 중요도가 높은지는 따지지 않아도 된다
                     */
                    if (curr[1] < q.get(i)[1]) {
                        // curr부터 큐에 다시 넣어야지
                        q.offer(curr);
                        // curr보다 중요도가 더 높은 작업이 있으므로 i 전까지에 있는 작업은 모두 i 뒤로 보낸다
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }
                        // curr이 현재 최고 중요도가 아니어서 뒤로 갔으므로 이제 다음 큐를 뽑아야 한다.
                        continue outer;
                    }
                }

                // for문을 잘 끝내고 여기에 도달했다는 것은 중요도가 가장 높은 작업이라는 것이다.
                // 작업을 끝냈으니 cnt를 증가시켜주고
                cnt++;
                // 현재 뽑은 작업의 순서가 m과 같다면
                if (curr[0] == m) {
                    System.out.println(cnt);
                    break; // 현재 테스트케이스 종료
                }
            }
        }
    }
}
