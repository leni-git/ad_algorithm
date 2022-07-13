import java.util.*;

public class ReportSolution implements Solution{

    ReportSolution() { run(this); }

    @Override
    public void process() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        /**
         * 1. 누가 누구를 신고 했는지 알아야한다.
         * 2. k 만큼 누적신고된 자가 있는지 알아야한다.
         * 3. 신고 승인 된 자를 신고 한 이에게 메일을 발송해야한다.
         */
        int[] answer = new int[id_list.length];
        // 누가 누구에게 신고 당했는가.
        Map<String, List<String>> accused = new HashMap<>();

        for(String str : report){
            String[] info = str.split(" ");
            String from = info[0];
            String to = info[1];

            if(accused.containsKey(to)){
                if(!accused.get(to).contains(from)){
                    accused.get(to).add(from);
                }
            } else {
                List<String> val = new ArrayList<>();
                val.add(from);
                accused.put(to, val);
            }
        }

        System.out.println(accused);

        for(Map.Entry<String, List<String>> ent : accused.entrySet()){
            List<String> reporters = ent.getValue();
            // 신고자가 k 명 이상이면 카운트 증가
            if(reporters.size() >= k){
                for(String rid : reporters){
                    for(int i=0; i<id_list.length; i++){
                        String id = id_list[i];
                        if(id.equals(rid)){
                            answer[i]++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
