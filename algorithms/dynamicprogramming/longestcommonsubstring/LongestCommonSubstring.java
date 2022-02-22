public class LongestCommonSubstring {
    
    public static int find(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int result = 0;

        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        int[][] dpGrid = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dpGrid[i][j] = dpGrid[i-1][j-1] + 1;
                    } else {
                        dpGrid[i][j] = 1;
                    }

                    if (dpGrid[i][j] > result) {
                        result = dpGrid[i][j];
                    }
                }
            }
        }

        return result;
    }
}