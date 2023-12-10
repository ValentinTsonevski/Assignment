package Encapsulation2;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public int getEndurance() {
        return endurance;
    }

    private void setEndurance(int endurance) {
        if(endurance >= 0 && endurance <= 100){
            this.endurance = endurance;
        }else {
            System.out.println("Endurance should be between 0 and 100.");
        }
    }

    public int getSprint() {
        return sprint;
    }

    private void setSprint(int sprint) {
        if(sprint >= 0 && sprint <= 100){
            this.sprint = sprint;
        }else {
            System.out.println("Sprint should be between 0 and 100.");
        }
    }

    public int getDribble() {
        return dribble;
    }

    private void setDribble(int dribble) {
        if(dribble >= 0 && dribble <= 100){
            this.dribble = dribble;
        }else {
            System.out.println("Dribble should be between 0 and 100.");
        }
    }

    public int getPassing() {
        return passing;
    }

    private void setPassing(int passing) {
        if(passing >= 0 && passing <= 100){
            this.passing = passing;
        }else {
            System.out.println("Passing should be between 0 and 100.");
        }
    }

    public int getShooting() {
        return shooting;
    }

    private void setShooting(int shooting) {
        if(shooting >= 0 && shooting <= 100){
            this.shooting = shooting;
        }else {
            System.out.println("Shooting should be between 0 and 100.");
        }
    }

    public int calculateSkillLevel() {
        int statsSum = getEndurance() + getSprint() + getDribble() + getPassing() + getShooting();
        int averageSkillLevel = statsSum / 5;

        return averageSkillLevel;
    }

}
