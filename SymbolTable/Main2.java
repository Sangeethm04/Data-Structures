package SymbolTable;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        int gradeCount = 0;
        Double sum = 0.0;
        SymbolTable < String, Double > grades = new SymbolTable < String, Double > ();
        grades.put("A+", 4.33);
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);
        Scanner scanner = new Scanner(System.in);
        //Use ^D for EOF (end of file)

        while (scanner.hasNext()) {
            String key = scanner.next();
            System.out.println(key + "!");
            Double value = grades.get(key);
            if (value != null) {
                sum = sum + value;
                gradeCount++;
            } else {
                System.out.println(key + " is an invalid grade");
            }
        }
        scanner.close();


        System.out.println("GPA :" + sum / gradeCount);

        for (String s: grades) {
            System.out.println(s);
        }
    }

}