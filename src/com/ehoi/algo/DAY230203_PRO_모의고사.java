package com.ehoi.algo;

import java.util.*;

public class DAY230203_PRO_모의고사 {
    public int[] solution(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] stu_ans = new int[3];
        for (int i = 0; i < answers.length; i++) {
            // i번째 문제 정답이 각 학생이 찍은 답과 같다면
            if (answers[i] == stu1[i % 5]) stu_ans[0]++;
            if (answers[i] == stu2[i % 8]) stu_ans[1]++;
            if (answers[i] == stu3[i % 10]) stu_ans[2]++;
        }

        // 최고 많이 맞힌 사람의 정답 개수는?
        int max = Math.max(stu_ans[0], Math.max(stu_ans[1], stu_ans[2]));

        // 그 갯수를 맞힌 애들 전부다 집어 넣자
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == stu_ans[i])
                list.add(i);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i) + 1;
        }
        return answer;
    }
}
