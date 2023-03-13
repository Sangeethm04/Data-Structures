import java.util.*;
import edu.princeton.cs.algs4.Stack;

public final class Board {

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    private int n;
    private int hammingDistance;
    private int manhattanDistance;
    public int[][] tiles;
    private Stack < Board > neighbors;

    public Board(int[][] tiles) {
        this.tiles = tiles;
        hammingDistance = 0;
        manhattanDistance = 0;
        int n = tiles.length;
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                if (tiles[row][col] != n * row + col + 1) {
                    hammingDistance++;
                }
                int goalRow = (tiles[row][col] - 1) / n;
                int goalCol = (tiles[row][col] - 1) % n;

                manhattanDistance = Math.abs(row - goalRow) + Math.abs(col - goalCol);
            }
        }
    }

    // string representation of this board
    public String toString() {
        String output = "Dimension: " + n + "*" + n + "Hamming Distance: " + hammingDistance;
        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[0].length; col++) {
                System.out.println(tiles[row][col]);
            }
        }
        return output;

    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        return hammingDistance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattanDistance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        if (hammingDistance == 0) {
            return true;
        } else {
            return false;
        }
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return true;

        if (y.getClass() != this.getClass())
            return false;

        Date that = (Date) y;

        if (this.day != that.day)
    }

    // private helper method
    private void createNeighbors() {
        int[] blank = findBlank();
        int row = blank[0];
        int col = blank[1];

        if (row > 0) {
            int[][] copy = copyTiles();
            copy[row][col] = copy[row - 1][col];
            copy[row - 1][col] = 0;
            neighbors.push(new Board(copy));
        }
        if (row < n - 1) {
            int[][] copy = copyTiles();
            copy[row][col] = copy[row + 1][col];
            copy[row + 1][col] = 0;
            neighbors.push(new Board(copy));
        }
        if (col > 0) {
            int[][] copy = copyTiles();
            copy[row][col] = copy[row][col - 1];
            copy[row][col - 1] = 0;
            neighbors.push(new Board(copy));
        }
        if (col < n - 1) {
            int[][] copy = copyTiles();
            copy[row][col] = copy[row][col + 1];
            copy[row][col + 1] = 0;
            neighbors.push(new Board(copy));
        }

    }

    private int[][] copyTiles() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                copy[i][j] = tiles[i][j];
        return copy;
    }

    private int[] findBlank() {
        int[] blank = new int[2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (tiles[i][j] == 0) {
                    blank[0] = i;
                    blank[1] = j;
                    return blank;
                }
        return null;
    }


    // Neighbors method
    public Iterable < Board > neighbors() {
        createNeighbors();
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {

    }
}