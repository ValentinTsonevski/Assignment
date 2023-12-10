package Encapsulation2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<FootballTeam> teams = new ArrayList<>();
        List<Player> players = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            Player player;

            String[] data = line.split(";");
            String command = data[0];
            String teamName = data[1];

            Optional<FootballTeam> footballTeam = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst();

            switch (command) {

                case "Team":
                    FootballTeam team = new FootballTeam(teamName);
                    teams.add(team);
                    break;

                case "Add":
                    String playerName = data[2];
                    int endurance = Integer.parseInt(data[3]);
                    int sprint = Integer.parseInt(data[4]);
                    int dribble = Integer.parseInt(data[5]);
                    int passing = Integer.parseInt(data[6]);
                    int shooting = Integer.parseInt(data[7]);

                    player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                    players.add(player);

                    if (teams.contains(footballTeam.get())) {
                        footballTeam.ifPresent(t -> t.getPlayers().add(player));
                    } else {
                        System.out.printf("Team %s does not exists.%n", teamName);
                    }
                    break;

                case "Remove":
                    String namePlayer = data[2];
                    player = players.stream().filter(p -> p.getName().equals(namePlayer)).findFirst().orElse(null);

                    if (footballTeam.isPresent() && player != null) {

                        if (footballTeam.get().getPlayers().contains(player)) {
                            footballTeam.get().getPlayers().remove(player);
                        } else {
                            System.out.printf("Player %s is not in %s.%n", namePlayer, teamName);
                        }
                    }
                    break;

                case "Rating":
                    if (teams.contains(footballTeam.get())) {
                        System.out.printf("%.0f %n", footballTeam.get().getRating());
                    } else {
                        System.out.printf("Team %s does not exists.%n",teamName);
                    }
                    break;
            }
            line = scanner.nextLine();
        }

    }
}
