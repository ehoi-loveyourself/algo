package com.ehoi.algo.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DAY230304_BOJ10423_전기가부족해 {
    static int[] parent;
    static String electricity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 발전소는 부모를 -1로 초기화
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        // 간선 정보를 저장할 배열을 만들기
        int[][] info = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        // 비용을 오름차순으로 정렬
        Arrays.sort(info, (o1, o2) -> Integer.compare(o1[2], o2[2]));
//        System.out.println(Arrays.deepToString(info));
        // 비용이 작은 것부터 유니온파인드


        int ans = 0;
        for (int i = 0; i < m; i++) {
            int a = info[i][0];
            int b = info[i][1];

            // 부모가 같으면 패스
            if (find(a) == find(b)) continue;

            union(a, b);
            ans += info[i][2];

            // 모든 도시가 발전소에 연결됐다면? = 즉 모두 -1 이라면?
            if (isAllConnected()) break;
        }
//        System.out.println(Arrays.toString(parent));
        System.out.println(ans);
    }

    private static boolean isAllConnected() {
        boolean flag = true;
        // 모두 -1일거야
        for (int i : parent) {
            if (i != -1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static int find(int x) {
        if (parent[x] == -1) return -1;
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean isElec(int x) {
        // 발전소인지 체크
        return electricity.contains(String.valueOf(x));
    }

    private static void union(int x, int y) {
        // 부모를 찾아서
        x = find(x);
        y = find(y);

        if (x == -1 && y != -1) {
            parent[y] = x;
        } else if (x != -1 && y == -1) {
            parent[x] = y;
        } else {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}

// 발전소 건물과 케이블
// 케이블 설치 비용 최소화
// 모든 도시에 전기 공급
// 최소 스패닝 트리 -> 크루스칼(유니온 파인드)
