import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    public BaseballGame() {

    }

    public int play() {
        int gameCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("< 게임을 시작합니다 >");
        while (true) {

            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요");
            String userNum = scanner.next();

            // 2. 올바른 입력값을 받았는지 검증
            boolean check = validateInput(userNum);
            if(!check) {
                System.out.println("올바르지 않은 입력값입니다");
            }

            // 3. 게임 진행횟수 증가
            gameCount++;
            System.out.println("게임 진행 횟수 : " + gameCount);

            // 4. 스트라이크 개수 계산


            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출


            // 6. 볼 개수 계산


            // 7. 힌트 출력

        }
        // 게임 진행횟수 반환
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
        return 0;
    }

    private int countBall(String input) {
        return 0;
    }
}
