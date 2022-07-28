package leni.date_220728;

import leni.Solution;

public class 숫자문자열과영단어 implements Solution {

    public 숫자문자열과영단어() { run(this); }

    private final String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    @Override
    public void process() {
        String[] input = {
                "one4seveneight"
                , "123"
                , "23four5six7"
                , "1zerotwozero3"
                , "oneoneoneoneone"
                , "oneone345"
        };

        for(String in : input){
            System.out.println(in+" >> "+solution(in));
        }
    }

    public int solution(String s){
        for (int idx=0; idx < NUMBERS.length; idx++) {
            s = s.replace(NUMBERS[idx], Integer.toString(idx));
        }

        return Integer.parseInt(s);
    }

    public int solution_wrong(String s){

        int answer = 0;

        for (int idx=0; idx < NUMBERS.length; idx++) {

            // 영문자가 포함되어 있는지 검색
            boolean isAllNumbers = !s.matches(".*[a-z|A-Z].*");
            if(isAllNumbers) {
                answer = Integer.parseInt(s);
                break;
            }

            s = s.replace(NUMBERS[idx], Integer.toString(idx));
        }

        return answer;
    }
}
