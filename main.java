public class Main {
    int[][] tiles = new int[3][3];

    public Main(int[][] tiles) {
        this.tiles = tiles;
    }

    public static void main(String[] args) {
        int[][] tiles = new int[3][3];
        tiles[0][0] = 1;
        tiles[0][1] = 2;
        tiles[0][2] = 3;
        tiles[1][0] = 4;
        tiles[1][1] = 5;
        tiles[1][2] = 6;
        tiles[2][0] = 8;
        tiles[2][1] = 7;
        tiles[2][2] = 0;
        Solver solver = new Solver(new Board(tiles));
        System.out.println(solver.isSolvable());
        //call solver method
        for (Board board : solver.solution())
        System.out.println(board);
    }

  
}
