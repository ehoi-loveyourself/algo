package com.ehoi.algo.lecture;

import java.util.*;

public class Lec45_공주구하기_조세퍼스_큐활용 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        while (!q.isEmpty()) {
            if (cnt == k) {
                list.add(q.poll());
                cnt = 1;
            }
            else {
                q.add(q.poll());
                cnt++;
            }
        }
        System.out.println(list.get(list.size() - 1));
        sc.close();
    }
}
