package com.ehoi.algo;

import java.util.*;

public class DAY230203_PRO_더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐
        Queue<Integer> pq = new PriorityQueue<>();

        // 스코빌 지수 오름차순 완성
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        boolean possible = true;
        while (true) {
            // 큐안에 있는 스코빌 지수가 모두 K 이상이면 브레이크
            /*
             * 이것은 필요없는 로직이었다. 우선순위 큐라서 가장 앞에 나와있는 원소의 스코빌 지수가 가장 낮을 테고
             * 그러므로 그것만 확인 하면 되는 일임.. 나는 바보다 ><
            if (check(pq, K)) break;
             */
//            if (pq.peek() >= K) break; // 는 얘도 NPE 우려가 있음

            // 큐의 사이즈가 1개 이하이면 NPE
            if (pq.size() <= 1) {
                possible = false;
                break;
            }

            if (pq.peek() >= K) break; // 는 사이즈 점검하고 그 다음에 점검하면 됨 -> 역시 로직 순서가 중요

           int first = pq.poll();
            int second = pq.poll();

            int mix = first + (second * 2);
            pq.add(mix);
            answer++;
        }

        if (!possible) return -1;
        else return answer;
    }

    /*
     * 이것은 필요없는 로직이었다. 우선순위 큐라서 가장 앞에 나와있는 원소의 스코빌 지수가 가장 낮을 테고
     * 그러므로 그것만 확인 하면 되는 일임.. 나는 바보다 ><
    private static boolean check(Queue<Integer> queue, int K) {
        boolean flag = true;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.stream().anyMatch(a -> a < K)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
     */

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;
        int output = solution(scoville, K);
        System.out.println(output);
    }
}
