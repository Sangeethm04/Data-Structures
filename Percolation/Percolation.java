public class Percolation {

    // number of open sites
    private int numsitesopen;
    private Site[][] grid;

    // creates n-by-n grid, with all sites initially blocked
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
        if (!grid[row][col].getOpen()) {
            grid[row][col].setOpen(true);
            numsitesopen++;
        }
        System.out.println("a");
        if (row == 0) {
            grid[row][col].setConnectedToOpenTop(true);
        }

        if (row == grid.length - 1) {
            grid[row][col].setConnectedToOpenBottom(true);
        }
        //union with top and bottom and right and left
        System.out.println("c");
        if (grid[row][col + 1].getOpen()) {
            System.out.println("d");
            Union(grid[row][col], grid[row][col + 1]);
        }

        if (grid[row][col - 1].getOpen()) {
            System.out.println("e");
            Union(grid[row][col], grid[row][col - 1]);
        }   

        if (grid[row + 1][col].getOpen()) {
            System.out.println("f");
            Union(grid[row][col], grid[row + 1][col]);
        }

        if (grid[row - 1][col].getOpen()) {
            System.out.println("g");
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