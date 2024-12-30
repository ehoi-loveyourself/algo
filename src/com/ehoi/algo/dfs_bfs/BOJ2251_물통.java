package com.ehoi.algo.dfs_bfs;

import java.io.*;
import java.util.*;

public class BOJ2251_물통 {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        List<Integer> ans = bfs();
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> bfs() {
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
        Set<Integer> results = new TreeSet<>(); // 얘가 자동 정렬까지 해준다고 한다.
        Queue<Jugs> queue = new LinkedList<Jugs>();
        queue.add(new Jugs(0, 0, C));

        while (!queue.isEmpty()) {
            Jugs curr = queue.poll();
            int x = curr.x, y = curr.y, z = curr.z;

            // 이 조합을 우리가 계산한 적이 있던가?
            if (visited[x][y][z]) continue;
            visited[x][y][z] = true;

            // A 물통이 비어있을 때 C 물통의 물의 양을 저장하자.
            if (x == 0) {
                results.add(z);
            }

            // 이제 물을 붓자
            // 1. x -> y
            pour(queue, x - Math.min(x, B - y), y + Math.min(x, B - y), z);
            // 2. x -> z
            pour(queue, x - Math.min(x, C - z), y, z + Math.min(x, C - z));
            // 3. y -> x
            pour(queue, x + Math.min(y, A - x), y - Math.min(y, A - x), z);
            // 4. y -> z
            pour(queue, x, y - Math.min(y, C - z), z + Math.min(y, C - z));
            // 5. z -> x
            pour(queue, x + Math.min(z, A - x), y, z - Math.min(z, A - x));
            // 6. z -> y
            pour(queue, x, y + Math.min(z, B - y), z - Math.min(z, B - y));
        }

        return new ArrayList<>(results);
    }

    private static void pour(Queue queue, int nx, int ny, int nz) {
        if (nx >= 0 && ny >= 0 && nz >= 0) {
            queue.add(new Jugs(nx, ny, nz));
        }
    }

    static class Jugs {
        int x, y, z;

        public Jugs(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}