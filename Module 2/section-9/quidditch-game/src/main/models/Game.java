package src.main.models;

import java.util.HashMap;

public class Game {

    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    public static final int QUAFFLE_POINTS = 10;
    public static final int SNITCH_POINTS = 150;

    public Game (Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount ++;
    }

    public Integer getScore(Team team) {
        return scoreboard.get(new Team(team));
    }

    public void setScore(Team team, Integer score) {
        if (team == null) {
            throw new IllegalArgumentException("team cannot be null");
        }
        this.scoreboard.put(new Team(team), score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
                                       .filter((key) -> key.getHouse().equals(name))
                                       .findFirst()
                                       .orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

    public String getPlaceholder(String play) {
        return play.substring(1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String name) {
        return play.replace("<" + placeholder + ">", name);
    }

    public void quaffleScore(Team team) {
        setScore(team, getScore(team) + QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        setScore(team, getScore(team) + SNITCH_POINTS);
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String name = "";

        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            name = team.getChasers()[getRandom(3)];
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            name = team.getSeeker();
        } else {
            name = team.getKeeper();
        }

        return replacePlaceholder(play, placeholder, name);
    }

    public Team getRandomTeam() {
        return (Team)this.scoreboard.keySet().toArray()[getRandom(2)];
    }

    public int getRandom(int range) {
        return (int)(Math.random() * (range));
    }
}
