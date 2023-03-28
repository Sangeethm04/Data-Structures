import java.util.*;
import edu.princeton.cs.algs4.Stack;

public final class Board {

  // create a board from an n-by-n array of tiles,
  // where tiles[row][col] = tile at (row, col)
  private int n;
  private int hammingDistance;
  private int manhattanDistance;
  public int[][] tiles;
  private Stack<Board> neighbors;

  public Board(int[][] tiles) {
    this.tiles = copyBoard(tiles);
    hammingDistance = 0;
    manhattanDistance = 0;
    int n = tiles.length;
    for (int row = 0; row < this.tiles.length; row++) {
      for (int col = 0; col < this.tiles[row].length; col++) {
        if (this.tiles[row][col] != n * row + col + 1) {
          hammingDistance++;
        }
        int goalRow = (this.tiles[row][col] - 1) / n;
        int goalCol = (this.tiles[row][col] - 1) % n;

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
        if (y == null) return false;

        Board news = (Board) y;
        for(int row = 0; row<tiles.length; row++) {
          for(int col=0; col<tiles[row].length;col++) {
             if(this.tiles[row][col] != news.tiles[row][col]) {
               return false;
             }
          }
        }
    return true;
    }

  // private helper method
  private void createNeighbors() {
    int zero[] = findZero();
    int zeroRow = zero[0];
    int zeroCol = zero[1];

    if (zeroRow > 0) {
      int[][] copyBoard = copyBoard(tiles);
      copyBoard[zeroRow][zeroCol] = copyBoard[zeroRow - 1][zeroCol];
      copyBoard[zeroRow - 1][zeroCol] = 0;
      neighbors.push(new Board(copyBoard));
    }
    if (zeroRow < n-1) {
      int[][] copyBoard = copyBoard(tiles);
      copyBoard[zeroRow][zeroCol] = copyBoard[zeroRow + 1][zeroCol];
      neighbors.push(new Board(copyBoard));
    }
    if (zeroCol > 0) {
      int[][] copyBoard = copyBoard(tiles);
      copyBoard[zeroRow][zeroCol] = copyBoard[zeroRow][zeroCol-1];
      neighbors.push(new Board(copyBoard));
    }
    if (zeroCol < n-1) {
       int[][] copyBoard = copyBoard(tiles);
      copyBoard[zeroRow][zeroCol] = copyBoard[zeroRow][zeroCol+1];
      neighbors.push(new Board(copyBoard));
    }

  }

  private int[] findZero() {
    int zero[] = { 0, 0 };
    for (int row = 0; row < tiles.length; row++) {
      for (int col = 0; col < tiles[0].length; col++) {
        if (tiles[row][col] == 0) {
          zero[0] = row;
          zero[1] = col;
        }
      }
    }
    return zero;

  }

  private int[][] copyBoard(int[][] tiles) {
    int newBoard[][] = new int[n][n];
    for (int row = 0; row < tiles.length; row++) {
      for (int col = 0; col < tiles[0].length; col++) {
        newBoard[row][col] = tiles[row][col];
      }
    }
    return newBoard;
  }

  // Neighbors method
  public Iterable<Board> neighbors() {
    neighbors = new Stack<Board>();
    createNeighbors();
    return (Iterable<Board>) neighbors;
  }


  // a board that is obtained by exchanging any pair of tiles
  public Board twin() {
   Board tilesNew = new Board(copyBoard(tiles));
    if(tiles[n-1][n-1] != 0) {
      tiles[n-1][n-1] = tiles[n-2][n-2];
    }
    return tilesNew;
  }
}