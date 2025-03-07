import java.util.Arrays;

public class Task_4 {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? "
                + areAnagrams(s1, s2));
    }

    private static boolean areAnagrams(String s1, String s2) {
        char[] str1= s1.toCharArray();
        char[] str2= s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return new String(str1).contentEquals(new String(str2));
    }
}