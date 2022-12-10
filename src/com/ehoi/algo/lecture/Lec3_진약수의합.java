package com.ehoi.algo.lecture;

import java.util.*;

public class Lec3_진약수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int sum = 1;
        sb.append(1);

        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                sum += i;
                sb.append(" + ").append(i);
            }
        }
        sb.append(" = ").append(sum);

        System.out.println(sb);
    }
}

/*
 진약수 : 어떤 자연수 N의 약수들 중에서 자기 자신을 제외한 약수를 진약수라고 한다.
 */