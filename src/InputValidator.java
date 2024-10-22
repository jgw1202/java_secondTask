import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public boolean validateInput(String input) {
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
}
