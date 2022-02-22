public class LongestCommonSubsequence {
    
    public static int find(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

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
                } else {
                    if (i > 0 && j > 0) {
                        dpGrid[i][j] = Math.max(dpGrid[i - 1][j], dpGrid[i][j - 1]);
                    } else if (i == 0 && j > 0) {
                        dpGrid[i][j] = dpGrid[i][j - 1];
                    } else if (j == 0 && i > 0) {
                        dpGrid[i][j] = dpGrid[i - 1][j];
                    }
                }
            }
        }

        return dpGrid[l1 - 1][l2 - 1];
    }
}