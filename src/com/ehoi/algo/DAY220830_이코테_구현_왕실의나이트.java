package com.ehoi.algo;

import java.util.*;

public class DAY220830_이코테_구현_왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.next();
        int[] spot = new int[2];
        spot[0] = tmp.charAt(0) - 'a'; // 열
        spot[1] = tmp.charAt(1) - '1'; // 행

        int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nr = spot[1] + dr[i];
            int nc = spot[0] + dc[i];

            // nr, nc 둘다 0 - 7 사이에 있어야 함
            if(nr < 0 || nc < 0 || nr > 7 || nc > 7) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
