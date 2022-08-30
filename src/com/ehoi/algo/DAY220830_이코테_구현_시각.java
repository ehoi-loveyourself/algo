package com.ehoi.algo;

import java.util.*;

public class DAY220830_이코테_구현_시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k <60; k++) {
                    String time = "" + i + j + k;
                    if(time.contains("3")) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
