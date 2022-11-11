// // Write a small program that causes an arithmetic exception (divide by zero).
// // Put it in a try-catch block.
// // In the catch block, call all of the different exception methods and print the results. 

// public class exer1 {
//     public static void main(String[] args) {
//         try {
//             int a = 1;
//             int b = 0;
//             int c = a / b;
//         } catch (ArithmeticException e) {
//             System.out.println("1: " + e);
//             System.out.println("2: " + e.getMessage());
//             System.out.println("3: " + e.getCause());
//             System.out.println("4: " + e.toString());
//             System.out.println("5: " + e.getStackTrace());
//             System.out.println("6: " + e.fillInStackTrace());
//         }
//     }
// }