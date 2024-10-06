package com.ehoi.algo.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1461_도서관 {
    static int power;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int books = Integer.parseInt(st.nextToken());
        power = Integer.parseInt(st.nextToken());

        // 이제 책 위치를 입력받을 건데 본인 위치(0)를 기준으로 왼쪽과 오른쪽을 나눠서 절대값으로 받을거고 큰 수부터 정렬이 되도록 우선순위 큐에 넣을 거야
        PriorityQueue<Integer> booksOnLeft = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> booksOnRight = new PriorityQueue<>(Collections.reverseOrder());

        // 그리고 가장 멀리 있는 책 위치를 기억해둘거야. 마지막에 책 정리하고 다시 안 돌아올거거든.
        int maxDist = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < books; i++) {
            int num = Integer.parseInt(st.nextToken());
            int num_abs = Math.abs(num);

            maxDist = Math.max(num_abs, maxDist);

            if (num > 0) {
                booksOnRight.add(num_abs);
            } else {
                booksOnLeft.add(num_abs);
            }
        } // 이제 입력된 정보를 바탕으로 준비가 끝났어

        // 1. 운반할 수 있는 양만큼 큐에서 제거하고 가장 거리가 먼 책 길이 * 2 를 계속 더해
        // 2. 마지막에 가장 긴 거리를 한번만 빼주면 그게 정답
        // 큐를 두번 보내야 하니까 메서드를 만들어서 보내자.
        int ans = getMinWalk(booksOnLeft) + getMinWalk(booksOnRight) - maxDist;
        System.out.println(ans);
    }

    private static int getMinWalk(PriorityQueue<Integer> queue) {
        int result = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll(); // 얘가 가장 긴 거야

            // 운반할 수 있는 양만큼 남은 책들도 뽑아줘야해
            for (int p = 1; p < power; p++) {
                // 근데 뽑을 게 있어야 뽑지
                if (!queue.isEmpty()) queue.poll();
            }

            result += poll * 2;
        }

        return result;
    }
}