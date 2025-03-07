public class Main {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + Math.abs(a - b));
        System.out.println("Product: " + (a * b));
        System.out.println("Quotient: " + (double) a / b);
    }
}