import java.util.ArrayList;
import java.util.List;

public class Exercise_02 {
    public static void main(String[] args) {

    }

    public static class IpFinder {

        public List<String> findAllPossibleIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            backTracking(0, s, new ArrayList<>(), result);
            return result;
        }

        private void backTracking(int start, String s, List<String> container, List<String> result) {
            if (start == s.length() && container.size() == 4) {
                result.add(String.join(".", container));
                return;
            }

            if (container.size() >= 4) {
                return;
            }

            for (int i = 1; i <= 3; i++) {
                if (start + i > s.length()) {
                    break;
                }

                String element = s.substring(start, start + i);
                if ((element.charAt(0) == '0' && element.length() > 1) || Integer.parseInt(element) > 255) {
                    continue;
                }

                container.add(element);
                backTracking(start + i, s, container, result);
                container.remove(container.size() - 1);
            }
        }

    }

}
