public class Exercise_10 {
    public static void main(String[] args) {
//        Exercise_10 exercise_10 = new Exercise_10();
       findPartyWinner("RD");
     findPartyWinner("RDD");

    }

    public static void findPartyWinner(String senate) {
        int n = senate.length();
        char[] senators = senate.toCharArray();

        int radiantCount = 0;
        int direCount = 0;
        boolean[] banned = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (banned[i]) {
                    continue;
                }
                if (senators[i] == 'R') {
                    radiantCount++;
                } else {
                    direCount++;
                }
                if (radiantCount < direCount) {
                    banned[i] = true;
                    radiantCount--;
                } else if (direCount < radiantCount) {
                    banned[i] = true;
                    direCount--;
                }
            }

            if (radiantCount == 0) {
                System.out.println("Dire");
            } else if (direCount == 0) {
                System.out.println("Radiant");
            }
    }

}
