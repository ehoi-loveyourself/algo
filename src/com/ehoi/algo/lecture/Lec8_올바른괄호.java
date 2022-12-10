package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec8_올바른괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt < 0) break;
        }

        if (cnt == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}

// 실수한 점 : (()))( 와 같은 반례를 고려하지 못함
// 닫는 괄호가 여는 괄호보다 먼저 나오는 순간, 즉 -1이 되는 순간 올바르지 못한 괄호로 생각