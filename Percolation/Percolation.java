//almost working but not quite getting the indexing right
public class Percolation {

    // number of open sites
    private int numsitesopen;
    private Site[][] grid;

    // creates n-by-n grid, with all sites initially blocked using correct relative index
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n 0");
        }
        numsitesopen = 0;
        grid = new Site[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Site(i, j);
            }
        }
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        grid[row - 1][col - 1].setOpen(true);
        numsitesopen++;
        if (row == 1) {
            grid[row - 1][col - 1].setConnectedToOpenTop(true);
        }
        if (row == grid.length) {
            grid[row - 1][col - 1].setConnectedToOpenBottom(true);
        }
        if (row > 1 && grid[row - 1][col].getOpen()) {
            Union(grid[row][col], grid[row - 1][col]);
            System.out.println("a");
        }

        if (row < grid.length && grid[row + 1][col].getOpen()) {
            Union(grid[row][col], grid[row + 1][col]);
            System.out.println("b");
        }

        if (col > 1 && grid[row][col - 1].getOpen()) {
            Union(grid[row][col], grid[row][col - 1]);
            System.out.println("c");
        }

        if (col < grid.length && grid[row][col + 1].getOpen()) {
            Union(grid[row][col], grid[row][col + 1]);
            System.out.println("d");
        }

    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row - 1][col - 1].getOpen();
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return grid[row - 1][col - 1].getfull();
    }
    // returns the number of open sites
    public int numberOfOpenSites() {
        return numsitesopen;

    }

    public Site root(Site site) {
        while (site.getRow() != site.getCol()) {
            site = grid[site.getRow() - 1][site.getCol() - 1];
        }
        return site;
    }

    //make a weighted quick union
    public void Union(Site p, Site q) {
        Site rootP = root(p);
        Site rootQ = root(q);
        if (rootP.getSize() < rootQ.getSize()) {
            rootP.incrementSize(rootQ.getSize());
            rootQ.incrementSize(rootP.getSize());
            rootP.setfull(true);
            rootQ.setfull(true);
            rootP.setConnectedToOpenBottom(rootQ.getConnectedToOpenBottom());
            rootP.setConnectedToOpenTop(rootQ.getConnectedToOpenTop());
        } else {
            rootP.incrementSize(rootQ.getSize());
            rootQ.incrementSize(rootP.getSize());
            rootP.setfull(true);
            rootQ.setfull(true);
            rootP.setConnectedToOpenBottom(rootQ.getConnectedToOpenBottom());
            rootP.setConnectedToOpenTop(rootQ.getConnectedToOpenTop());
        }
    }

    public void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j].getOpen() + " ");
            }
            System.out.println();
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