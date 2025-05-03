package com.ehoi.algo.datastructure;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int target = 10;

        for (int num : arr) {
            if (target != num) {
                list.add(num);
            }
            target = num;
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}