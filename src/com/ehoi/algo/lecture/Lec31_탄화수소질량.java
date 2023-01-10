package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec31_탄화수소질량 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = new char[8]; // C100H100 최대 크기가 8이다
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            a[i] = str.charAt(i);
        }

        int ans = 0;
        int i = 1;
        StringBuilder sb = new StringBuilder();
        // C 다음 자리가 H라면 C는 1개 뿐이다
        if (a[1] == 'H') ans += 12;
            // 그게 아니라면 H가 나올때까지 나오는 숫자들을 구해서 C에 곱한 다음 ans에 더한다
        else {
            while (true) {
                sb.append(a[i]);
                i++;
                if (a[i] == 'H') break;
            }
            // sb를 숫자로 변환해서 12로 곱해서 ans에 더하자
            ans += 12 * Integer.parseInt(sb.toString());
        }
        // H가 나오면 뒤에 오는 숫자들을 구해서 H에 곱한 후에 ans에 더한다.
        // 현재 i가 H가 있는 위치니까 i + 1부터 빈문자열인지 확인하면서 숫자를 구한다
        i++;
        sb = new StringBuilder();
        // 여기서도 H 뒤에 아무 숫자도 없을 수도 있으니까
        if (a[i] == '\0') ans += 1;
        else {
            while (true) {
                sb.append(a[i]);
                i++;
                if (a[i] == '\0') break;
            }
            ans += Integer.parseInt(sb.toString());
        }
        System.out.println(ans);
        sc.close();
    }
}
