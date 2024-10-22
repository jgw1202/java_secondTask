import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator {
    public String generateAnswer() {
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
}
