import java.util.ArrayList;
import java.util.List;

public class Exercise_03 {
    public static void main(String[] args) {

    }

    public static class Program_03 {

        public String findLargestNumber(List<Integer> nums) {
            List<String> numsToString = new ArrayList<>();

            for (int num : nums) {
                numsToString.add(String.valueOf(num));
            }
            numsToString.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));

            if (numsToString.get(0).equals("0")) {
                return "0";
            }

            StringBuilder output = new StringBuilder();
            for (String numString : numsToString) {
                output.append(numString);
            }

            return output.toString();
        }
    }
}
