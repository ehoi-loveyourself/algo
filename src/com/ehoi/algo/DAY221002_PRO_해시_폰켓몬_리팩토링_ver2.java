package com.ehoi.algo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DAY221002_PRO_해시_폰켓몬_리팩토링_ver2 {
    public int solution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        set -> Integer.min(set.size(), nums.length / 2)));
    }
}
