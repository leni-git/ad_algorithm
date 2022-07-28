package ghchae;

public class ChangeSTringToNumber {
    public int solution(String s) {
        String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        System.out.println("num.length : " + numArr.length);

        System.out.println("String 값 : " + s);
        for (int i = 0; i < numArr.length; i++) {

            System.out.println("numArr[" + i + "] :" + numArr[i]);
            /* 조건에 맞는 모든 문자열 변경 */
            s = s.replace(numArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
