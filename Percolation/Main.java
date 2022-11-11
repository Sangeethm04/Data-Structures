// import java.util.Scanner;
// import java.io.*;
// class Main {
//   public static void main(String[] args) throws FileNotFoundException {

//     Scanner scanner = new Scanner(new File("testOrder1.rtf"));
//     int dim = scanner.nextInt();

//     Percolation grid = new Percolation(dim);
//     System.out.println(dim);

//     int row = 0;
//     int col = 0;
//     while (scanner.hasNextInt()) {
//       row = scanner.nextInt();
//       if (scanner.hasNextInt()) {
//         col = scanner.nextInt();
//         System.out.println(row + "  " + col);
//         grid.open(row, col);
//       }
//     }
//     grid.printGrid();
//     if (grid.percolates()) {
//       System.out.println("This grid percolates");
//     } else {

//       System.out.println("This grid does not percolate");
//       System.out.println("Number of Open Sites: " + grid.numberOfOpenSites());
//     }
//   }
// }