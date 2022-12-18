package com.ehoi.algo.datastructure;

import java.io.*;
import java.util.*;

public class BOJ1991_트리순회 {
    private static class Node {
        char value;
        Node left;
        Node right;

        public Node() {}

        public Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        char head = 'A';
        // 각 노드를 관리할 배열을 만들자
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Node(head++);
        }

        // 이제 입력을 받아보자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char curr = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            arr[curr - 'A'].left = left == '.' ? null : arr[left - 'A'];
            arr[curr - 'A'].right = right == '.' ? null : arr[right - 'A'];
        }

        // 이제 순회를 돌아보자 (전위 - 중위 - 후위)
        System.out.println(preorder(arr[0]));
        System.out.println(inorder(arr[0]));
        System.out.println(postorder(arr[0]));
    }

    // 나 - 왼 - 오
    private static String preorder(Node node) {
        String res = "";

        res += node.value;
        if (node.left != null) {
            res += preorder(node.left);
        }
        if (node.right != null) {
            res += preorder(node.right);
        }

        return res;
    }
    private static String inorder(Node node) {
        String res = "";

        if (node.left != null) {
            res += inorder(node.left);
        }
        res += node.value;
        if (node.right != null) {
            res += inorder(node.right);
        }

        return res;
    }
    private static String postorder(Node node) {
        String res = "";

        if (node.left != null) {
            res += postorder(node.left);
        }
        if (node.right != null) {
            res += postorder(node.right);
        }
        res += node.value;

        return res;
    }
}
