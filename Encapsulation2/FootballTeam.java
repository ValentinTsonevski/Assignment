package Encapsulation2;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {
    private String name;
    private double rating;
    private List<Player> players = new ArrayList<>();

    public FootballTeam(String name) {
       setName(name);
       setRating();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            System.out.println("A name should not be empty.");
        }else{
            this.name = name;
        }
    }

    public double getRating() {
        return rating;
    }

    private double setRating() {
        int skillLevelPlayers = 0;

        for (int i = 0; i < getPlayers().size(); i++) {
            skillLevelPlayers += getPlayers().get(i).calculateSkillLevel();
        }
        return skillLevelPlayers / getPlayers().size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void removePlayer(Player player) {
        getPlayers().remove(player);
    }

    public void addPlayer(Player player) {
        getPlayers().add(player);
    }

}
