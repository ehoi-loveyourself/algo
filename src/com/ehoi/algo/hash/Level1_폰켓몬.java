package com.ehoi.algo.hash;

import java.util.*;

public class Level1_폰켓몬 {
    public int solution(int[] nums) {
        // hashset에 담아서 포켓몬 같은 종류 제거
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int count = nums.length / 2; // 고를 수 있는 개수
        int total = set.size(); // 후보 개수

        return Math.min(count, total);
    }
}