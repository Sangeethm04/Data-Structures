class Main {
    public static void main(String[] args) {
        WorldCupTeam[] q = new WorldCupTeam[4];
        q[0] = new WorldCupTeam("Brazil", 0, 0);
        q[1] = new WorldCupTeam("Germany", 0, 0);
        q[2] = new WorldCupTeam("Argentina", 0, 0);
        q[3] = new WorldCupTeam("France", 0, 0);
        q[4] = new WorldCupTeam("USA", 0, 0);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    WorldCupTeam.play(q[i], q[j]);
                }
            }
        }

        System.out.println();

    }
}