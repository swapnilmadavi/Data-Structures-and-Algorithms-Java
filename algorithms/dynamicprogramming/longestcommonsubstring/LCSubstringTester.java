public class LCSubstringTester {
    
    public static void main(String[] args) {
        String s1 = "FISH";
        String s2 = "HISH";

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Length of longest common substring: " + LongestCommonSubstring.find(s1, s2));
    }
}