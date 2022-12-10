package com.ehoi.algo.lecture;

import java.util.*;

public class Lec5_나이계산_문자열컨트롤 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        char c = id.charAt(7);

        int year = Integer.parseInt(id.substring(0, 2));
        int birth;
        if (c == '1' || c == '2') {
            birth = 1900 + year;
        } else {
            birth = 2000 + year;
        }
        int age = 2019 - birth + 1;

        String gender;
        if (c == '1' || c == '3') {
            gender = "M";
        } else {
            gender = "W";
        }

        System.out.println(age + " " + gender);
    }
}

// 분기를 할 때 하나하나의 케이스를 나누려고 하지말고 나이는 나이대로 성별은 성별대로 분기하자!