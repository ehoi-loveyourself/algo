package com.ehoi.algo.lecture;

import java.util.*;

public class Lec72_공주구하기_큐자료구조_리팩터링포함 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
//        List<Integer> princes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

//        int cnt = 1;
//        while (!queue.isEmpty()) {
//            // k번째 왕자라면 그냥 poll해서 리스트에 추가
//            if (cnt == k) {
//                princes.add(queue.poll());
//            // 아니라면 poll 한거 다시 집어 넣고
//            } else {
//                queue.add(queue.poll());
//            }
//
//            // k ++ 하고 k가 4가 되면 다시 1로 바꾸고
//            cnt++;
//            if (cnt == 4) cnt = 1;
//        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                // 2번만 뽑아서 바로 집어넣어
                queue.add(queue.poll());
            }
            // 3번째는 걍 버려
            queue.poll();
            if (queue.size() == 1) {
                // 마지막 왕자가 남으면
                System.out.println(queue.poll());
            }
        }
//        System.out.println(princes);
//        System.out.println(princes.get(princes.size() - 1));
        sc.close();
    }
}
