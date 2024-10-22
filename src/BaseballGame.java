import java.util.Scanner;

public class BaseballGame {

    private final String answer;
    private final InputValidator inputValidator;
    private final HintCalculator hintCalculator;
    private final BaseballGameDisplay baseballGameDisplay;

    public BaseballGame() {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        this.answer = answerGenerator.generateAnswer();
        this.inputValidator = new InputValidator();
        this.hintCalculator = new HintCalculator(answer);
        this.baseballGameDisplay = new BaseballGameDisplay();
    }

    public int play() {
        int gameCount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("< 게임을 시작합니다 >");
        while (true) {
            System.out.println("정답 : " + answer); // Debugging 용도로 사용 (필요시 제거)
            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요");
            String userNum = scanner.next();

            // 2. 올바른 입력값을 받았는지 검증
            boolean check = inputValidator.validateInput(userNum);
            if (!check) {
                System.out.println("올바르지 않은 입력값입니다");
                continue;
            }

            // 3. 게임 진행횟수 증가
            gameCount++;
            System.out.println("게임 진행 횟수 : " + gameCount);

            // 4. 스트라이크와 볼 개수 계산
            int strikes = hintCalculator.countStrike(userNum);
            int balls = hintCalculator.countBall(userNum);

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (strikes == 3) {
                System.out.println("정답입니다!");
                break;
            }
            // 6. 힌트 출력
            baseballGameDisplay.displayHint(strikes, balls);
        }
        // 게임 진행횟수 반환
        return gameCount;
    }
}
