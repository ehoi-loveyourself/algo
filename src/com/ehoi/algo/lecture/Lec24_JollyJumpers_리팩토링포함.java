package com.ehoi.algo.lecture;

import java.util.Scanner;

public class Lec24_JollyJumpers_리팩토링포함 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        boolean[] flag = new boolean[101];
        boolean[] flag = new boolean[n];
        int pre = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            int now = sc.nextInt();
            int pos = Math.abs(pre - now);
            // 이 조건식이 포인트다!
            // pos가 flag[] 범위에 들어가지도 않고, 심지어 한번 체크됐다면
            // jolly jumpers가 아님!
            if (0 < pos && pos < n && !flag[pos]) {
                flag[pos] = true;
            } else {
                System.out.println("NO");
                System.exit(0);
            }
            pre = now;
        }
        System.out.println("YES");

        /**
         * 내가 작성한 이 방식은 비효율적이라고 한다.
         * 왜냐하면 pre - now의 차가 중복으로 들어와서 이미 true여도 개의치 않고
         * 계속 true로 받는다.
         * 이미 true인데 또 같은 값이 들어온다면 jolly jumpers 라고 할 수 없다.
         * 차가 1부터 n-1까지 모두 있어야 하므로 중복이라면 바로 NO를 뱉도록 하는 것이 좋다.
         * 그리고 이 여부를 확인하기 위해서 boolean 배열을 만들었는데 나는 101까지 만들었다.
         * 하지만 크기를 n 까지로만 하고 pre - now의 차가 이 배열의 범위를 벗어나버리면
         * 그 역시 jolly jumpers가 될 수 없으므로 NO를 뱉으면 된다.
         for (int i = 2; i <= n; i++) {
         int now = sc.nextInt();
         flag[Math.abs(pre - now)] = true;
         pre = now;
         }

         for (int i = 1; i < n; i++) {
         if (!flag[i]) {
         System.out.println("NO");
         System.exit(0);
         }
         }
         System.out.println("YES");
         */
    }
}
