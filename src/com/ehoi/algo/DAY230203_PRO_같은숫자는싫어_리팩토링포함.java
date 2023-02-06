package com.ehoi.algo;

import java.util.*;

public class DAY230203_PRO_같은숫자는싫어_리팩토링포함 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        int pre = 10;
        for (int curr : arr) {
            if (curr != pre) {
                list.add(curr);
            }

            pre = curr;
        }

        /*
        // 왜 큐에 넣었지...? 문제가 큐라서 큐에 넣은 건가 ㅋㅋㅋㅋㅋㅋ => 정답이긴 한데 리팩토링 하자
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }

        int prior = arr[0];
        list.add(prior);

        while (!q.isEmpty()) {
            // 큐에서 뽑았는데
            int curr = q.poll();

            // 이전 것과 다르다면 list에 넣고 같다면 아무 것도 하지마
            if (curr != prior) {
                list.add(curr);
            }

            // 현재 거를 이전 꺼로 갱신하고 다시 반복
            prior = curr;
        }
        */

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
