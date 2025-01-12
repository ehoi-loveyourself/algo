package com.ehoi.algo.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2668_숫자고르기 {
    static int N;
    static int[] arr, parent;
    static boolean[] isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        parent = new int[N + 1];
        isCycle = new boolean[N + 1];

        for (int i = 1; i <=N ;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            parent[i] = i; // 아직까지 자기의 친구는 자기밖에 없으므로 자기 자신으로 초기화 한다.
        }

        for (int i = 1; i <= N; i++) {
            union(i, arr[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                ans.add(i);
            }
        }

        System.out.println(ans.size());
        for (int num : ans) {
            System.out.println(num);
        }

        br.close();
    }

    // 최상단의 친구가 같은지 같다면 사이클이 형성된 거다.
    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) { // x와 y 사이에는 사이클이 형성된 것이므로 걔네를 다 표시해야 한다.
            markCycle(x); // x부터 시작해서 parent 배열 돌면서 친구들 다 표시하자
        } else { // 아니면 최상단 친구를 같게 만들어주자.
            parent[parentX] = parentY;
        }
    }

    // start랑 연결이 된 친구는 다 true로 바꿔서 사이클이 생겼다고 표시해줄거야
    private static void markCycle(int start) {
        int curr = start;

        do {
            isCycle[curr] = true;
            curr = arr[curr]; // parent[curr]; 얘는 다 압축되어 있어서 최상단 친구만 가지고 있으니까 틀렸어
        } while (curr != start); // curr과 start가 같을때까지 계속 최상단 친구들 찾아다니면서 사이클 표시해
    }

    private static int find(int num) {
        if (num == parent[num]) { // 나의 최상단 친구가 나 스스로면 그냥 나를 리턴하면 되고
            return num;
        }

        // 그게 아니라면 나의 최상단 친구를 찾으러 다시 find(parent[num])으로 재귀를 계속 호출하는데
        // 그러면 복잡도가 높아지니까 찾을 때마다 내 최상단 친구에 최신화를 해두면 경로가 압축이 되면서 금방 찾을 수 있게 됨
        return parent[num] = find(parent[num]);
    }
}