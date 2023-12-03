import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Exercise_08 {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        List<String> test = new ArrayList<>();
        test.add("5");
        test.add("2");
        test.add("C");
        test.add("D");
        test.add("+");
        System.out.println(baseballGame.calculateScores(test));
    }

    public static class BaseballGame {

        public int calculateScores(List<String> commands) {
            Stack<Integer> record = new Stack<>();

            for (String command : commands) {
                if (command.equals("C")) {
                    record.pop();
                } else if (command.equals("D")) {
                    record.push(2 * record.peek());
                } else if (command.equals("+")) {
                    int last = record.pop();
                    int secondLast = record.peek();
                    record.push(last);
                    record.push(last + secondLast);
                } else {
                    record.push(Integer.parseInt(command));
                }
            }
            int sum = 0;
            while (!record.isEmpty()) {
                sum += record.pop();
            }
            return sum;
        }
    }

}
