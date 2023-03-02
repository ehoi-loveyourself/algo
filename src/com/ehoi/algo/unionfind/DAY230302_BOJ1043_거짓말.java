package com.ehoi.algo.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class DAY230302_BOJ1043_거짓말 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        st = new StringTokenizer(br.readLine());
        int known = Integer.parseInt(st.nextToken());
        // 진실을 알고 있는 사람이 없으면 전체 파티 수만큼 다 이야기해도 됨
        if (known == 0) {
            System.out.println(m);
            System.exit(0);
        }
        // 진실을 알고 있는 사람 표시하기
        boolean[] knownPeople = new boolean[n + 1];
        for (int i = 0; i < known; i++) {
            knownPeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 자기 자신을 부모로 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 각 파티에 참여한 사람들 입력받기
        Set<Integer>[] party = new HashSet[m];
        // 그 전에 초기화해주기
        for (int i = 0; i < m; i++) {
            party[i] = new HashSet<>();
        }
        // 이제 입력받기
        for (int i = 0; i < m; i++) {
            // 그때 그때 읽어버리면 저장이 안되므로 배열에 저장을 해두고
            String[] input = br.readLine().split(" ");
            int howMany = Integer.parseInt(input[0]); // 파티에 오는 사람 수

            // 파티 참석 인원이 1명이면 구냥 집어 넣고 continue;
            if (howMany == 1) {
                party[i].add(Integer.parseInt(input[1]));
                continue;
            }
            // 2명 이상이면
            for (int j = 1; j < input.length - 1; j++) {
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j + 1]);

                // 그 2명을 합쳐
                union(a, b);

                // 그리고 둘다 참석 리스트에 넣어
                party[i].add(a);
                party[i].add(b);
            }
        }

//        System.out.println(Arrays.toString(parent));

        // 진실을 아는 사람과 연관 관계가 있으면 얘도 아는 사람 취급
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (knownPeople[i]) { // 진실을 알고 있는 사람이라면
                int p = find(i); // i의 부모를 찾아

                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (find(j) == p) { // 같은 종족이면
                        knownPeople[j] = true; // 너도 이제 그 진실을 알고 있어
                        visited[j] = true;
                    }
                }
            }
        }

        // 다시 그 파티 멤버로 돌아가서 한명이라도 진실을 알고 있으면 과장된 얘기 못함
        int ans = m;
        outer :
        for (int i = 0; i < m; i++) {
            for (int person : party[i]) {
                if (knownPeople[person]) { // 진실을 알고 있으면
                    ans--;
                    continue outer;
                }
            }
        }
        System.out.println(ans);
    }

    private static void union(int x, int y) {
        // 부모를 찾아서
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}
