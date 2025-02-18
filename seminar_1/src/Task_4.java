import java.util.Arrays;

public class Task_4 {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? "
                + areAnagrams(s1, s2));
    }

    private static boolean areAnagrams(String s1, String s2) {
        return s1.contentEquals(new StringBuilder(s2).reverse());
    }
}