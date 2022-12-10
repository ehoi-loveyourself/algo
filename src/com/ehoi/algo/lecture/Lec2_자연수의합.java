package com.ehoi.algo.lecture;

import java.util.*;

public class Lec2_자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int A = sc.nextInt();
        int B = sc.nextInt();

        sb.append(A);
        int sum = A;

        for (int i = A + 1; i <= B; i++) {
            sb.append("+").append(i);
            sum += i;
        }

        sb.append("=").append(sum);

        System.out.println(sb);
    }
}
