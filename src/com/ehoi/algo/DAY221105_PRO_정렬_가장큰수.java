package com.ehoi.algo;

import java.util.Arrays;

public class DAY221105_PRO_정렬_가장큰수 {
    public String solution(int[] numbers) {
        // 1. numbers에 있는 숫자를 문자로 바꾸고 순열로 조합한다
        // 그걸 다시 숫자로 담아서 list에 담는다
        // 2. 내림차순 정렬
        // 3. 가장 앞에 있는 숫자를 문자열로 바꿔서 리턴하기
        // ============ 위는 너무 구린 방법이야 ===================

        // 1. 문자열 배열을 만들어서 다 담고
        String[] s = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            s[i] = String.valueOf(numbers[i]);
        }

        // 2. sort를 하는데 문자열로 소팅을 할 때는 3, 30, 34, 5, 9 형식으로 정렬을 하게 되는데
        // 그러면 9534303으로 문자열이 붙어서 9534330 보다는 작으니까
        // 다르게 소팅을 해줘야 한다
        Arrays.sort(s, (a, b) -> {
                    return (a + b).compareTo(b + a);
                }
        );

        // 가장 큰 수가 0이라면 0을 뱉어야 한다. [0, 0] 이렇게 들어가 있으면 00이 될테니까
        if (s[s.length - 1].equals("0")) return "0";

        // 3. 그리고 정렬이 오름차순으로 되어있을 테니까 뒤에서부터 붙여주기
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            sb.append(s[i]);
        }

        /*
        // 2-1. 그런데 아예 sort을 할 때부터 내림차순으로 되게 sort을 해도 된다
        Arrays.sort(s, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // 이 경우에는 맨 앞에 있는 숫자가 0이면 그냥 0을 리턴해야 하니까
        if (s[0].equals("0")) return "0";

        StringBuilder sbb = new StringBuilder();
        // 앞에서부터 붙이기!
        for (int i = 0; i < s.length; i++) {
            sbb.append(s[i]);
        }
         */

        return sb.toString();
    }
}
