package hash;

import java.util.HashMap;

/**
 * Programmers Hash
 * Level 1 - 완주하지 못한 선수
 * 2022-03-22
 */

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            // player - key값, getORDefault(): 중복된 키값에 다른 value 넣어주기
            // value : 1 or 중복 key 값에 따라 n
            // + 1 을 해야 중복 key 값에 대한 value 값이 update 되지 않고 다른 값을 가짐
            // map.getOrDefault(player, 1) -> 중복 key 값에 대한 value 이 달라지지 않음
            // 중복되지 않는 key의 value 값들은 모두 1
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        // map객체에 같은 키값이 있으면 value 값을 0으로 update
        for (String player : completion) {
            // 중복되지 않는 key 값들은 0으로 변경
            map.put(player, map.getOrDefault(player, map.get(player)) - 1);
        }

        for (String player : map.keySet()) {
            if(map.get(player) != 0) answer = player;
        }
        // map의 value값이 0이 아닌 값 출력

        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"kiki", "eden"};

        Solution sol = new Solution();
        System.out.println(sol.solution(part, comp));
    }
}


