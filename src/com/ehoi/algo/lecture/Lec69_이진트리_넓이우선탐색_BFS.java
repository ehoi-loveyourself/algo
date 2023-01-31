package com.ehoi.algo.lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec69_이진트리_넓이우선탐색_BFS {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tree = new ArrayList[10];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        visited = new boolean[10];
        for (int i = 0; i < 6; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        visited[1] = true;
        bfs(1);
        sc.close();
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.printf("%d ", curr);

            for (int i = 0; i < tree[curr].size(); i++) {
                if (visited[tree[curr].get(i)]) continue;
                visited[tree[curr].get(i)] = true;
                queue.add(tree[curr].get(i));
            }
        }
    }
}
