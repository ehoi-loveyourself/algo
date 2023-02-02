package com.ehoi.algo;

import java.util.*;

public class DAY230202_PRO_여행경로 {
    private static boolean[] visited;
    private static Queue<String> pq = new PriorityQueue<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);

        // 그렇게 모든 경로를 탐색하고 pq에는 여러 경로들이 담겨있을 것이다.
        // 그중에서도 오름차순으로 정렬했기 때문에 가장 맨 앞에 있는 경로가 정답일 것임
        String[] answer = pq.peek().split(" ");
        return answer;
    }

    private static void dfs(String start, String path, String[][] tickets, int cnt) {
        // 티켓을 모두 사용했으면
        if (cnt == tickets.length) {
            // 우선순위 큐에 경로를 넣자. 자동으로 오름차순 정렬이 될 것임.
            pq.add(path);
            return;
        }

        // 그게 아니면 티켓을 돌면서
        // 현재 출발해야 하는 도시와 출발지가 같은 티켓을 찾자
        for (int i = 0; i < tickets.length; i++) {
            // 이미 사용한 티켓은 고려 대상 아님
            if (visited[i]) continue;
            if (tickets[i][0].equals(start)) {
                // 찾았으면 방문처리하고 탐색하러 가자
                visited[i] = true;
                // 현재 항공권의 도착지를 출발지로 선택해서 찾아야지 바보야
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, cnt + 1);
                // 탐색하고 왔으면 다음 경로 탐색을 위해 방문처리를 풀자
                visited[i] = false;
            }
        }
    }
}

/*
- 주어진 항공권 모두 이용
- 항상 ICN에서 출발
- 방문하는 공항 경로 배열에 담기
*/

/*
내가 생각했던 풀이 방식이랑 다름
인천에서 출발해야 하니까 인천을 찾아서 탐색하는게 아니라 그냥 걍 인천(start)을 찍고 탐색함
티켓 중에 start 출발이 있고 그 티켓을 아직 사용 안했으면 그거 사용하고 dfs 돌리는데
그런 티켓이 여러개 있을 거니까 경로가 다양해질 수 있음

그래서 결국엔 티켓을 다 사용하고 난 후의 경로가 여러개가 될텐데 그것 전부를 오름차순으로 그때 정렬하는 거임 미리 하는 게 아니고 (오 근데 다른 사람 풀이코드 보니까 우선순위 큐 사용해서 정렬도 아예 안함)
*/
