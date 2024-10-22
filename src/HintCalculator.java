public class HintCalculator {

    private final String answer;

    public HintCalculator(String answer) {
        this.answer = answer;
    }

    public int countStrike(String input) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(String input) {
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
