package com.ehoi.algo;

import java.util.*;

public class DAY221002_PRO_큐_같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        int value = -1; // arr에는 없을 값 지정
        for (int i = 0; i < arr.length; i++) {
            // 값이 다를 때만 넣으면 돼
            if (arr[i] != value) {
                list.add(arr[i]);
                value = arr[i]; // 비교 기준으로 지정
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public int[] solution_ver2(int []arr) {
        List<Integer> list = new ArrayList<>();

        int value = -1; // arr에는 없을 값 지정
        for (int i = 0; i < arr.length; i++) {
            // 값이 다를 때만 넣으면 돼
            if (arr[i] != value) {
                list.add(arr[i]);
                value = arr[i]; // 비교 기준으로 지정
            }
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();

    }
}
