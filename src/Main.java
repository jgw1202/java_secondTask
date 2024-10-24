import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> gameTryList = new ArrayList<Integer>();
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int gameNumber = scanner.nextInt();

            if (gameNumber == 1) {
                // 1. 게임 시작하기
                BaseballGame baseballGame = new BaseballGame();
                int gameTry = baseballGame.play();
                gameTryList.add(gameTry);

            } else if (gameNumber == 2) {
                // 2. 게임 기록 보기
                System.out.println("< 게임 기록 보기 >");
                if(gameTryList.isEmpty()) {
                    System.out.println("게임을 진행하지 않아 기록이 없습니다.");
                }
                for (int i = 0; i < gameTryList.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + gameTryList.get(i));
                }
            } else if (gameNumber == 3) {
                // 3. 종료
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                return;
            } else {
                System.out.println("올바른 숫자를 입력해주세요!");
            }
        }
    }
}
