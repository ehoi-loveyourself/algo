package com.ehoi.algo;

// 효율성에서 실패한 코드
public class DAY221013_PRO_DFS_게임맵최단거리 {
    static int answer = 987654321; // 임의의 큰수 지정
    static boolean[][] visited; // 방문처리할 배열

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        dfs(maps, 0, 0, 1); // x좌표 0, y좌표 0, 이동 수 1

        return answer == 987654321 ? -1 : answer;
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static void dfs(int[][] maps, int x, int y, int cnt) {
        if (x == maps.length - 1 && y == maps[0].length - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
            if (maps[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            // 내가 자꾸 까먹는 부분
            // 방문처리를 해주고 나와서는 방문처리 취소를 해줘야함
            visited[nx][ny] = true;
            dfs(maps, nx, ny, cnt + 1);
            visited[nx][ny] = false;
        }
    }
}
