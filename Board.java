public final class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private int n;
    private int hammingdistance;
    private int manhattan;

    public Board(int[][] tiles) {
        n = tiles.length;
        hammingdistance = 0;
        manhattan = 0;
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col] != 0) {
                    if (tiles[row][col] != row * n + col + 1) {
                        hammingdistance++;
                    }
                    int goalRow = (tiles[row][col] - 1) / n;
                    int goalCol = (tiles[row][col] - 1) % n;
                    manhattan += Math.abs(goalRow - row) + Math.abs(goalCol - col);
                }
            }
        }
    }

    // string representation of this board
    public String toString() {

    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        return hammingdistance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hammingdistance == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {

    }

    // all neighboring boards
    public Iterator < Board > neighbors() {

    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {

    }
}