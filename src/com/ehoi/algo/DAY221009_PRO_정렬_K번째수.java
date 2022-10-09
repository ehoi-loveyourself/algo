package com.ehoi.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DAY221009_PRO_정렬_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {

            int s = commands[i][0] - 1;
            int e = commands[i][1];
            /* ver 1
            List<Integer> list = new ArrayList<>();
            for (int j = s; j < e; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
             */

            int[] temp = Arrays.copyOfRange(array, s, e);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}

