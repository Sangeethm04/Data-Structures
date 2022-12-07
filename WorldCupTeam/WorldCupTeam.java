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
        if (this.equals(o)) {
            return 0;
        }
        if (this.wins / (this.wins + this.losses) > o.wins / (o.wins + o.losses)) {
            return 1;
        } else if (this.wins / (this.wins + this.losses) < o.wins / (o.wins + o.losses)) {
            return -1;
        } else {
            if (this.country.compareTo(o.country) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
            
    }

    public String toString() {
        return ("Team " + country + " has " + wins + " wins and " + losses + " losses");
    }

    public boolean equals(WorldCupTeam i, WorldCupTeam j) {
        if (i.country.equals(j.country)) {
            return true;
        }
        return false;
    }

    public static WorldCupTeam play(WorldCupTeam i, WorldCupTeam j) {
        if (i.equals(j)) {
            return i;
        }
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random == 0) {
            i.wins++;
            j.losses++;
        } else {
            i.losses++;
            j.wins++;
        }
        return i;
    }

}