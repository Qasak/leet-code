package leetcode.HighFreq;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/25 23:01
 */
public class Q5_最长回文字串 {
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int n = s.length();
        if(n == 1) {
            return s;
        }
        boolean dp[][] = new boolean[n][n];
        for(int i = 0; i < n; i++ ) {
            dp[i][i] = true;
        }
        char[] cs = s.toCharArray();
        int x = 0, y = 0;
        for(int len = 1; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                if(len == 1) {
                    if(cs[i] == cs[j]) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = ((cs[i] == cs[j]) && dp[i + 1][j - 1]);

                }
                if(dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        String ans = "";
        int max = 0;
        for(int len = 1; len <= n; len++) {
            for(int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if(len == 1) {
                    f[l][r] = true;
                } else if(len == 2) {
                    if(s.charAt(l) == s.charAt(r)) {
                        f[l][r] = true;
                    } 
                } else {
                    if(s.charAt(l) == s.charAt(r)) {
                        f[l][r] = f[l + 1][r - 1];
                    }
                }
                if(f[l][r]) {
                    if(len > max) {
                        ans = s.substring(l, r + 1);
                        max = len;
                    }
                }
            }

        }
        return ans;
    }
    // 中心扩散

    // Manacher 算法 O(n)
}
