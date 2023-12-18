import java.util.ArrayList;
import java.util.List;

public class Exercise_10 {
    public static void main(String[] args) {
        String test1 = "RD";
        System.out.println(findPartyWinner(test1));

        String test2 = "RDD";
        System.out.println(findPartyWinner(test2));
    }

    public static String findPartyWinner(String senate) {
        List<Character> radiant = new ArrayList<>();
        List<Character> diary = new ArrayList<>();

        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R'){
                radiant.add(senate.charAt(i));
            }else if(senate.charAt(i) == 'D'){
                diary.add(senate.charAt(i));
            }
        }

        if (radiant.size() == diary.size()) {
            char firstParty = senate.charAt(0);
            if(firstParty == 'R'){
                return "Radiant";
            }else if(firstParty == 'D'){
                return "Diary";
            }
        }

      return radiant.size() > diary.size() ? "Radiant" : "Diary";

    }

}
