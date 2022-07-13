package leni.date_220713;
import leni.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */

class ReportInfo {

    private final ArrayList<Integer> reportUserSeqList;
    private int reportCount;

    ReportInfo(){
        this.reportUserSeqList = new ArrayList<>();
        this.reportCount = 0;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void addReportUserSeqList(int userSeq) {
        this.reportUserSeqList.add(userSeq);
    }

    public ArrayList<Integer> getReportUserSeqList() {
        return reportUserSeqList;
    }

    public boolean isFirstReport(int userSeq) {
        return !this.reportUserSeqList.contains(userSeq);
    }

    public void plusReportCount() {
        this.reportCount++;
    }
}

public class 신고결과받기 implements Solution {

    public 신고결과받기(){
        run(this);
    }

    @Override
    public void process() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; // 유저 아이디 리스트
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}; // 유저 신고 히스토리 - format : 신고자 피신고자
        int k = 2; // 정지당하는 신고 횟수
        System.out.print(Arrays.toString(this.solution(id_list, report, k)));

         String[] id_list1 = {"con", "ryan"}; // 유저 아이디 리스트
        String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"}; // 유저 신고 히스토리 - format : 신고자 피신고자
        int k1 = 3; // 정지당하는 신고 횟수
        System.out.print(Arrays.toString(this.solution(id_list1, report1, k1)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, ReportInfo> reportHistory = new HashMap<String, ReportInfo>();

        for (String history: report ) {
            String reportUser = history.split(" ")[0];
            String blackUser = history.split(" ")[1];

            ReportInfo reportInfo = reportHistory.get(blackUser);
            if(reportInfo == null){
                reportInfo = new ReportInfo();
            }

            int userSeq = Arrays.asList(id_list).indexOf(reportUser);
//            System.out.println(reportUser+" report "+blackUser+" : "+userSeq);
            if(reportInfo.isFirstReport(userSeq)){
                reportInfo.addReportUserSeqList(userSeq);
                reportInfo.plusReportCount();
            }

            reportHistory.put(blackUser, reportInfo);
        }

        for(String blackUser: reportHistory.keySet()){
            ReportInfo reportInfo = reportHistory.get(blackUser);
            if(k <= reportInfo.getReportCount()){
                for(int userSeq: reportInfo.getReportUserSeqList()){
                    answer[userSeq]++;
                }
            }
        }

        return answer;
    }
}