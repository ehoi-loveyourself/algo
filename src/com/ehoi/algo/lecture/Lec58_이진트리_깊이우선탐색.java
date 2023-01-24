package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec58_이진트리_깊이우선탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
        System.out.println();
        sc.close();
    }

    private static void preorder(int n) {
        if (n > 7) return;
        System.out.printf("%d ", n);
        preorder(n * 2);
        preorder(n * 2 + 1);
    }

    private static void inorder(int n) {
        if (n > 7) return;
        inorder(n * 2);
        System.out.printf("%d ", n);
        inorder(n * 2 + 1);
    }

    private static void postorder(int n) {
        if (n > 7) return;
        postorder(n * 2);
        postorder(n * 2 + 1);
        System.out.printf("%d ", n);
    }
    /* 리팩토링
    private static void preorder(int n) {
        // 나 - 왼 - 오
        System.out.printf("%d ", n);
        // 왼쪽이 있으면 왼쪽을 출력해
        if (n * 2 < 8) preorder(n * 2);
        // 오른쪽도
        if (n * 2 + 1 < 8) preorder(n * 2 + 1);
    }

    private static void inorder(int n) {
        // 왼 - 나 - 오
        // 왼쪽이 있으면 왼쪽을 출력해
        if (n * 2 < 8) inorder(n * 2);
        System.out.printf("%d ", n);
        // 오른쪽도
        if (n * 2 + 1 < 8) inorder(n * 2 + 1);
    }

    private static void postorder(int n) {
        // 왼 - 오 - 나
        // 왼쪽이 있으면 왼쪽을 출력해
        if (n * 2 < 8) postorder(n * 2);
        // 오른쪽도
        if (n * 2 + 1 < 8) postorder(n * 2 + 1);
        System.out.printf("%d ", n);
    }
     */
}
