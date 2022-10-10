public class Percolation {

  // number of open sites
  private int numsitesopen;
  private Site[][] grid;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("n must be greater than 0");
    }
    numsitesopen = 0;
    grid = new Site[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = new Site(i + 1, j + 1);
      }
    }
  }
  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
      if (!grid[row][col].getOpen()) {
          grid[row][col].setOpen(true);
          numsitesopen++;
      }

      if (row == 0) {
          grid[row][col].setConnectedToOpenTop(true);
      }

      if (row == grid.length - 1) {
          grid[row][col].setConnectedToOpenBottom(true);
      }
      //union with top and bottom and right and left

      if (!grid[row][col + 1].getOpen()) {
         Union(grid[row][col], grid[row][col + 1]);
      }

        if (!grid[row][col - 1].getOpen()) {
             Union(grid[row][col], grid[row][col - 1]);
        }

        if (!grid[row + 1][col].getOpen()) {
             Union(grid[row][col], grid[row + 1][col]);
        }

        if (!grid[row - 1][col].getOpen()) {
             Union(grid[row][col], grid[row - 1][col]);
        }
        
  }
  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
      return grid[row][col].getOpen();
  }
  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
      return grid[row][col].getfull();
  }
  // returns the number of open sites
  public int numberOfOpenSites() {
      return numsitesopen;
  }

  public Site root(int row, int col) {
      while (!grid[row][col].getConnectedToOpenTop()) {
          row = grid[row][col].getRow();
          col = grid[row][col].getCol();
      }
      return grid[row][col];
  }


  public void Union(Site p, Site q) {
      Site i = root(p.getRow(), p.getCol());
      Site j = root(q.getRow(), q.getCol());
      if (i == j) {
          return;
      }
      if (i.getConnectedToOpenBottom() && j.getConnectedToOpenBottom()) {
          i.setConnectedToOpenBottom(true);
          j.setConnectedToOpenBottom(true);
      }
      if (i.getConnectedToOpenTop() && j.getConnectedToOpenTop()) {
          i.setConnectedToOpenTop(true);
          j.setConnectedToOpenTop(true);
      }
  }
      
  // does the system percolate?
  public boolean percolates() {
      for (int i = 0; i < grid.length; i++) {
          if (grid[grid.length - 1][i].getConnectedToOpenTop()) {
              return true;
          }
      }
      return false;
  }
  // test client 
  public static void main(String[] args) {

  }
}