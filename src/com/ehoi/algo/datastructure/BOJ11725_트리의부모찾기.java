package com.ehoi.algo.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725_트리의부모찾기 {
    private static class Node {
        int value;
        List<Integer> list = new ArrayList<>();
    }

    private static Node[] arr;
    private static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드의 개수
        arr = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new Node();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].list.add(e);
            arr[e].list.add(s);
        }

        // 루트가 1일 때 각 노드의 부모를 정리해보자
        ans = new int[N + 1];
        recur(1, -1);

        // 노드 2부터 끝까지 차례대로 ans를 출력하자
        for (int i = 2; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        br.close();
    }

    private static void recur(int curr, int parent) {
        ans[curr] = parent;

        // 리프노드라면 리턴
        if (arr[curr].list.size() == 1 && parent != -1) return;

        // 아니라면 curr과 연결되어 있는 아이들 중에 부모가 없으면 curr을 부모로 지정
        for (int i : arr[curr].list) {
            if (i != parent) recur(i, curr);
        }
    }
}
