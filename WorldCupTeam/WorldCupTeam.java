import java.util.*;

public class WorldCupTeam implements Comparable < WorldCupTeam > {
    String country;
    int wins;
    int losses;

    public WorldCupTeam(String country, Integer wins, Integer losses) {
        this.country = country;
        this.wins = wins;
        this.losses = losses;
    }

    @Override
    public int compareTo(WorldCupTeam o) {
        double thisWL = (double) this.wins / (this.losses + this.wins);
        double otherWL = (double)o.wins / (o.wins + o.losses);
        System.out.println(this.country + " " +  this.wins + " " + this.losses + " " + thisWL);
        System.out.println(o.country + " " + o.wins + " " + this.losses + " " + otherWL);


        if (this.equals(o)) {
            System.out.println(0);
            return 0;
        } else if (thisWL > otherWL) {
            System.out.println(1);
            return 1;
        } else if (thisWL < otherWL) {
            System.out.println(-1);
            return -1;
        } else {
            if (this.country.compareTo(o.country) < 0) {
                System.out.println("1 alpha");
                return 1;
            } else {
                System.out.println("-1 alpha");
                return -1;
            }
        }
    }

    
    public boolean equals(WorldCupTeam that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        if (this.country.equals(that.country) && this.wins == that.wins && this.losses == that.losses) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return ("Team " + country + " has " + wins + " wins and " + losses + " losses");
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