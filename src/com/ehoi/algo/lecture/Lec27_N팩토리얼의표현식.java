package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec27_N팩토리얼의표현식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n + 1]; // 소수가 몇개 있는지 표현할 배열은 n까지만 있으면 된다.
        // n보다 더 큰 소수는 나올리가 없으므로

        for (int i = 2; i <= n; i++) {
            // i에 대해 소인수 분해를 하자.
            // i는 계속 커져야 하는 수이므로, tmp에 담아서 운용하자
            int tmp = i;
            int j = 2; // tmp를 소인수 분해할 소수이다. 2부터 시작한다.
            while (true) {
                if (tmp % j == 0) {
                    ans[j]++;
                    tmp /= j;
                } else {
                    j++; // j가 한 숫자로 계속 나뉜다면 나뉠때까지 계속 j로 나누고
                    // 안 나뉜다면 그때 j를 1 증가시킨다.
                }
                // 이 과정에서 j가 2부터 시작하므로 4나 6과 같은 소수가 아닌 수로 나뉠 염려는 하지 않아도 된다.
                // 2로 나뉠만큼 충분히 나누고 3, 4, 5 로 증가하는 것이므로 4로 나뉠 일이 없다.
                if (tmp == 1) break; // tmp가 이제 더이상 나뉠 것이 없다면 빠져나온다.
            }
        }
        System.out.printf("%d! = ", n);
        for (int i : ans) {
            if (i != 0) System.out.printf("%d ", i);
        }

    }
}
