package leni.date_220713;
import leni.Solution;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
import java.util.*;

public class 신고결과받기 implements Solution {

    public 신고결과받기(){
        run(this);
    }

    @Override
    public void process() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // 유저 아이디 리스트
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; // 유저 신고 히스토리 - format : 신고자 피신고자
        int k = 2; // 정지당하는 신고 횟수
        System.out.println(Arrays.toString(this.solution(id_list, report, k)));

         String[] id_list1 = {"con", "ryan"}; // 유저 아이디 리스트
        String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"}; // 유저 신고 히스토리 - format : 신고자 피신고자
        int k1 = 3; // 정지당하는 신고 횟수
        System.out.println(Arrays.toString(this.solution(id_list1, report1, k1)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        /* HashSet: 중복을 허용하지 않는 타입 implement set, null 허용 */
        Map<String, HashSet<Integer>> reportHistory = new HashMap<>();

        for (String history: report ) {
            /* stringTokenizer: split 을 대체하여 사용할 수 있다.
            서로 약간의 차이점은 있으나 동작 상으로 봤을 때 stringTokenizer 가 좀 더 빠른 것 같음 */
            StringTokenizer historyToken = new StringTokenizer(history);
            String reportUser = historyToken.nextToken();
            String blackUser = historyToken.nextToken();

            /* getOrDefault: 있으면 첫번째 매개변수, 없으면 두번째 매개변수 값을 반환한다. */
            HashSet<Integer> reportInfo = reportHistory.getOrDefault(blackUser, new HashSet<>());

            int userSeq = Arrays.asList(id_list).indexOf(reportUser);
            reportInfo.add(userSeq);
            reportHistory.put(blackUser, reportInfo);
        }

        for(HashSet<Integer> reportUserList: reportHistory.values()){
            if(k <= reportUserList.size()){
                reportUserList.forEach(idx -> answer[idx]++);
            }
        }

        return answer;
    }
}