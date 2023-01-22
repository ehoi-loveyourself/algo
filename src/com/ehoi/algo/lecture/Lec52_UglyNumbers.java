package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec52_UglyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        // 어글리 넘버의 첫번째 수는 1로 한다고 한다. -> 이게 이 문제를 풀 수 있는 지점이 되기도 함
        arr[1] = 1;
        // 소인수 2, 3, 5를 핸들링할 포인터를 모두 1로 세팅해둔다
        int p2 = 1; int p3 = 1; int p5 = 1;
        int min = 987654321;
        for (int i = 2; i <= n; i++) {
            // 일단 두개 중에서 최솟값을 찾자
            if (arr[p2] * 2 < arr[p3] * 3) min = arr[p2] * 2;
            else min = arr[p3] * 3;
            // 나머지 하나랑이랑도 비교하자
            if (arr[p5] * 5 < min) min = arr[p5] * 5;
            // 찾았다! 최솟값을 나타나게 한 포인터를 ++ 하자
            if (min == arr[p2] * 2) p2++;
            if (min == arr[p3] * 3) p3++;
            if (min == arr[p5] * 5) p5++;

            arr[i] = min;
        }
        System.out.println(arr[n]);
        sc.close();
    }
}
