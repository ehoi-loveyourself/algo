package com.ehoi.algo.hash;

import java.util.*;

public class Level3_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
// 2. 장르별로 음악을 묶기
        Map<String, List<Music>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            // 음악을 만들어서
            String genre = genres[i];
            Music music = new Music(genre, plays[i], i);

            // 장르별 음악 리스트에 넣기
            if (genreMap.get(genre) == null) {
                genreMap.put(genre, List.of(music));
            } else {
                genreMap.get(genre).add(music);
            }
        }

        // 3. 재생횟수별로 장르를 관리할 맵 만들기
        Map<String, Integer> playCntByGenre = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<Music> musicList = genreMap.get(genre);

            int sum = 0;
            for (Music music : musicList) {
                sum += music.getPlayCnt();
            }

            playCntByGenre.put(genre, sum);
        }

        // 4. 재생이 가장 많이 된 장르부터 정렬하기
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((a, b) -> playCntByGenre.get(b) - playCntByGenre.get(a));

        int[] answer = {};
        return answer;
    }

    // 1. Music 이라는 클래스로 장르, 재생횟수, 고유번호를 한꺼번에 관리
    class Music implements Comparable<Music> {
        private String genre;
        private int playCnt;
        private int id;

        public Music(String genre, int playCnt, int id) {
            this.genre = genre;
            this.playCnt = playCnt;
            this.id = id;
        }

        public int getPlayCnt() {
            return this.playCnt;
        }

        @Override
        public int compareTo(Music other) {
            if (this.playCnt == other.playCnt) {
                return this.id - other.id; // 고유번호가 낮은 순
            }
            return other.playCnt - this.playCnt; // 재생 횟수가 높은 순
        }
    }
}