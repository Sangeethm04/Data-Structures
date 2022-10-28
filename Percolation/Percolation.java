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
        System.out.println("n: " + n);
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
        //row and col are real numbers, not the index
        int rowIndex = row - 1;
        int colIndex = col - 1;
        System.out.println(" opening :" + row + " " + col);
        grid[rowIndex][colIndex].setOpen(true);
        numsitesopen++;
        if (row == 1) {
            grid[rowIndex][colIndex].setConnectedToOpenTop(true);
        }
        if (row == grid.length) {
            grid[rowIndex][colIndex].setConnectedToOpenBottom(true);
        }
        //look up
        if (row > 1 && grid[rowIndex - 1][colIndex].getOpen()) {
            System.out.println("a");
            Union(grid[rowIndex][colIndex], grid[rowIndex - 1][colIndex]);
            System.out.println("a");
        }
        //look down
        if (row < grid.length && grid[rowIndex + 1][colIndex].getOpen()) {
            System.out.println("b");
            Union(grid[rowIndex][colIndex], grid[rowIndex + 1][colIndex]);

        }
        //look left
        if (col > 1 && grid[rowIndex][colIndex - 1].getOpen()) {
            System.out.println("c");
            Union(grid[rowIndex][colIndex], grid[rowIndex][colIndex - 1]);

        }
        //look right
        if (col < grid.length && grid[rowIndex][colIndex + 1].getOpen()) {
            System.out.println("d");
            Union(grid[rowIndex][colIndex], grid[rowIndex][colIndex + 1]);

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
        while(site.getRow() != site.getRow() | site.getCol() != site.getCol()) {
            site = grid[site.getRow()][site.getCol()];
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
        System.out.println("grid length: " + grid.length);
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