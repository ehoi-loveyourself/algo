package com.ehoi.algo.hash;

import java.util.*;

public class Level2_의상 {
    public int solution(String[][] clothes) {
        // 종류 별로 의상 개수 세서 map에 저장
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int ans = 1;
        for (String key : map.keySet()) {
            ans *= map.get(key) + 1;
        }
        return ans - 1;
    }
}