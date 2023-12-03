import java.util.*;

public class Exercise_07 {
    public static void main(String[] args) {
       Matches matches = new Matches();

        List<List<Integer>> matches1 = Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(3, 6),
                Arrays.asList(5, 6), Arrays.asList(5, 7), Arrays.asList(4, 5),
                Arrays.asList(4, 8), Arrays.asList(4, 9), Arrays.asList(10, 4),
                Arrays.asList(10, 9)
        );
        System.out.println(matches.findPlayers(matches1));
    }

    public static class Matches {

        public List<List<Integer>> findPlayers(List<List<Integer>> matches) {
            Map<Integer, Integer> wins = new HashMap<>();
            Map<Integer, Integer> losses = new HashMap<>();

            fillMaps(matches, wins, losses);
            incrementMaps(matches, wins, losses);

            List<Integer> notLost = new ArrayList<>();
            List<Integer> lostOnce = new ArrayList<>();

            for (int player : wins.keySet()) {
                if (!losses.containsKey(player)) {
                    notLost.add(player);
                } else if (losses.get(player) == 1) {
                    lostOnce.add(player);
                }
            }

            Collections.sort(notLost);
            Collections.sort(lostOnce);

            return Arrays.asList(notLost, lostOnce);
        }

        private void incrementMaps(List<List<Integer>> matches, Map<Integer, Integer> wins, Map<Integer, Integer> losses) {
            for (List<Integer> match : matches) {
                int winner = match.get(0);
                int loser = match.get(1);

                wins.put(winner, wins.get(winner) + 1);
                losses.put(loser, losses.get(loser) + 1);
            }
        }

        private void fillMaps(List<List<Integer>> matches, Map<Integer, Integer> wins, Map<Integer, Integer> losses) {
            for (List<Integer> match : matches) {
                int winner = match.get(0);
                int loser = match.get(1);

                wins.put(winner,0);
                losses.put(loser,0);
            }
        }

    }


}
