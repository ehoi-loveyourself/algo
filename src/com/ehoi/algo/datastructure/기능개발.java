package com.ehoi.algo.datastructure;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] period = new int[progresses.length];

        for (int i = 0; i < period.length; i++) {
            int left = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                left++;
            }
            period[i] = left;
        }

        List<Integer> list = new ArrayList<>();
        int target = period[0];
        int cnt = 1;
        for (int i = 1; i < period.length; i++) {
            if (target < period[i]) {
                list.add(cnt);
                cnt = 1;
                target = period[i];
            } else {
                cnt++;
            }
        }
        list.add(cnt);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}