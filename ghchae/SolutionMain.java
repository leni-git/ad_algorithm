package ghchae;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SolutionMain {
    public static void main(String[] args) {
        testOrDefault();/* java8에서 제공하는 ordDefault메소드를 이해하기 위한 테스트*/
        String[] part = {"en", "en", "ko", "te", "ce"};

        String[] comp = {"en", "en", "te", "ce"};
        System.out.println(solution(part, comp));
    }

    public static String solution(String[] participant, String[] completion) {
        /* participant = 참여한선수들(n명), completion = 완주한 선수들(n-1명), 1~ 100000명 */
        String answer = "";

        /* list = 순서o,중복o | map = 순서x, 중복(키x,값o) */
        /*
            동명이인이 존재 , 키 중복 x, 값 중복 o
            정렬 후 비교 할 경우 -> 동명이인이 존재하면 꼬여버릴듯..
             그래서 해당 key에 대한 count를 저장
        */

        HashMap<String, Integer> map = new HashMap<>();
        for (String personName : participant) {
            /* participant 배열의 0 부터 ~ , 값을 personName 으로 */

            /* psersonName 이라는 키값이 존재하면 default + 1 , 아니면 default값을 넣는다. */
            map.put(personName, map.getOrDefault(personName, 0) + 1);
        }

        for (String personName : completion) {
            /* 완주목록에 있는 이름이 , 참가자목록에 존재하면 값을 - 1 */
            map.put(personName, map.get(personName) - 1);
        }
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    public static void testOrDefault() {
        String[] testCode = {"le", "ko", "ko", "en"};
        HashMap<String, Integer> testMap = new HashMap<>();

        for (String key : testCode) {
            testMap.put(key, testMap.getOrDefault(key, 0) + 1);
        }
        System.out.println("result : " + testMap);
    }
}
