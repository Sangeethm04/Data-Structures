import java.util.*;

public class WorldCupTeam implements Comparable < WorldCupTeam > {
    String country;
    Integer wins;
    Integer losses;

    public WorldCupTeam(String country, Integer wins, Integer losses) {
        this.country = country;
        this.wins = wins;
        this.losses = losses;
    }

    @Override
    public int compareTo(WorldCupTeam o) {
        {
            if (o.wins < wins) {
                return 1;
            } else if (o.wins > wins) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public String toString() {
        return ("Team " + country + "has " + wins + " wins and " + losses + " losses");
    }

    public static WorldCupTeam play(WorldCupTeam i, WorldCupTeam j) {
        if (i.country.equals(j)) {
            int num = (int) Math.random() * 2;
            if (num == 0) {
                i.wins++;
                return i;
            } else {
                j.wins++;
                return j;
            }
        }
        return null;
    }
}