package com.ehoi.algo;

import java.util.*;

public class DAY230203_PRO_가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 1. 인접 리스트를 만든다.
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 2. 거리 배열을 만들고 -1로 채운다.
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // 3. 1번 노드는 거리가 0이다.
        dist[1] = 0;

        // 4. 노드를 연결 시키자
        for (int i = 0; i < edge.length; i++) {
            int[] curr = edge[i];
            list[curr[0]].add(curr[1]);
            list[curr[1]].add(curr[0]);
        }

        // 5. bfs
        int maxDist = 0;
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(1, 0));

        while (!q.isEmpty()) {
            Item curr = q.poll();

            // 이 노드와 연결된 노드를 찾자
            for (int i = 0; i < list[curr.node].size(); i++) {
                int next = list[curr.node].get(i);
                // 이 노드를 방문한 적이 없으면
                if (dist[next] == -1) {
                    // 방문하고 큐에 넣자
                    dist[next] = curr.distance + 1;
                    q.add(new Item(next, dist[next]));

                    // 그리고 이 거리가 최장거리면 갱신하자
                    maxDist = Math.max(maxDist, dist[next]);
                }
            }
        }

        /*
        // 4. 첫번째 노드부터 n번째 노드까지 돌면서 연결된 노드를 찾는다.
        for (int i = 1; i < list.length; i++) {
            // 이미 다 가봤는데 노드 끝까지 계속 탐색하는 것은 시간이 걸리니까
            if (allVisited(dist)) break;

            for (int j = 0; j < list[i].size(); j++) {
                int node = list[i].get(j);
                // 그 노드 길이기 -1이면 아직 안왔다는 뜻이니까 갱신한다.
                if (dist[node] == -1) {
                    // 갱신하는 길이는 i에서 왔기 때문에 i + 1 해주면 됨
                    dist[node] = dist[i] + 1;
                    // 최장거리 갱신
                    maxDist = Math.max(dist[node], maxDist);
                }
            }
        }
        */

        // 6. 이제 최장거리와 같은 노드를 찾자
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == maxDist) answer++;
        }
        System.out.println(Arrays.toString(dist));
        return answer;
    }

    private class Item {
        int node;
        int distance;

        public Item(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
