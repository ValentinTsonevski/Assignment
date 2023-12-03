import java.util.ArrayList;
import java.util.List;

public class Exercise_06 {
    public static void main(String[] args) {

    }

    public static class RepeatingNumbers {
        public List<Integer> findTheRepeatingNumbers(int[] input) {
            List<Integer> container = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < input.length; i++) {
                if (!container.contains(input[i])) {
                    container.add(input[i]);
                }else{
                    result.add(input[i]);
                }

            }
            return result;
        }

    }

}
