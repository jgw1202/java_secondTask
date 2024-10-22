import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    private final String answer;
    public BaseballGame() {
        this.answer = generateAnswer();
    }

    private String generateAnswer() {
        Set<Character> digitsSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (digitsSet.size() < 3) {
            int digit = (int) (Math.random() * 9) + 1;
            char digitChar = (char) ('0' + digit);
            if (digitsSet.add(digitChar)) {
                sb.append(digitChar);
            }
        }
        return sb.toString();
    }

    public int play() {
        int gameCount = 0;
        Scanner scanner = new Scanner(System.in);
        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
        System.out.println("< 게임을 시작합니다 >");
        while (true) {
            System.out.println("정답 : " + answer);
            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요");
            String userNum = scanner.next();

            // 2. 올바른 입력값을 받았는지 검증
            boolean check = validateInput(userNum);
            if(!check) {
                System.out.println("올바르지 않은 입력값입니다");
                continue;
            }

            // 3. 게임 진행횟수 증가
            gameCount++;
            System.out.println("게임 진행 횟수 : " + gameCount);

            // 4. 스트라이크 개수 계산
            int strikes = countStrike(userNum);

            // 5. 볼 개수 계산
            int balls = countBall(userNum);

            // 6. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strikes == 3) {
                System.out.println("정답입니다!");
                break;
            }
            // 7. 힌트 출력
            baseballGameDisplay.displayHint(strikes, balls);
        }
        // 게임 진행횟수 반환
        return gameCount;
    }


    protected boolean validateInput(String input) {
        if (input == null || input.length() != 3) {
            return false;
        }
        Set<Character> digitsSet = new HashSet<>();
        for (char digitChar : input.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (digit < 1 || digit > 9 || !digitsSet.add(digitChar)) {
                return false;
            }
        }

        return true;
    }

    private int countStrike(String input) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(String input) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c != answer.charAt(i) && answer.indexOf(c) != -1) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
