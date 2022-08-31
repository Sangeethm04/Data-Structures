import java.util.*;

public class chap1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        doubleArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void doubleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    public static void doubleArray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }
}
