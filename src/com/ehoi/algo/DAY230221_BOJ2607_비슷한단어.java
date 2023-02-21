package com.ehoi.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DAY230221_BOJ2607_비슷한단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine();
        char[] targetArr = new char[26];
        for (int i = 0; i < target.length(); i++) {
            targetArr[target.charAt(i) - 'A']++;
        }

        int ans = 0;
        char[][] othersArr = new char[n - 1][26];
        for (int i = 0; i < n - 1; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < tmp.length(); j++) {
                othersArr[i][tmp.charAt(j) - 'A']++;
            }
            if (isSimilarWord(targetArr, othersArr[i])) ans++;
        }

        System.out.println(ans);
    }

    private static boolean isSimilarWord(char[] target, char[] other) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (target[i] == other[i]) continue;
            if (Math.abs(target[i] - other[i]) >= 2) return false;
            diff.add(target[i] - other[i]); // 1, -1만 담김
        }

        if (diff.size() == 1) return true; // 1, -1이 하나만 담겼다면 한번 더하거나 한번 빼주면 되니까 비슷한 단어 맞아
        else if (diff.size() >= 3) return false; // 하지만 이런 게 3개 이상 담겼다면 비슷한 단어 아니야
        else {
            // 두개만 담겼는데 그 두개가 하나는 -1, 1이라면 바꿔주면 되는 거니까 비슷한 단어 맞아
            int sum = 0;
            for (Integer integer : diff) {
                sum += integer;
            }
            return sum == 0;
        }
    }
}
