import java.util.Arrays;

public class Task_3 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        System.out.println("Numbers: " + numbers); // what is going on?
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sumArray(numbers));
    }

    private static int sumArray(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}