package com.ehoi.algo.lecture;

import java.util.Scanner;
import java.util.Stack;

public class Lec53_K진수출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int n = sc.nextInt();
        int k = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % k);
            n /= k;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(arr[stack.pop()]);
        }
        System.out.println(sb);
        sc.close();
    }
}
