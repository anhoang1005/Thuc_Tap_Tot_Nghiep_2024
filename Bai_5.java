package VCCORP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bai_5 {
	
    public static List<String> themDauCach(String s, List<String> tuDien) {
        Set<String> words = new HashSet<>(tuDien);
        List<String>[] dp = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<>();
        int l = 0, r=0;
        for (r = 1; r <= s.length(); r++) {
            dp[r] = new ArrayList<>();
            for (l = 0; l < r; l++) {
                String tu = s.substring(l, r);
                if (words.contains(tu)) {
                    if (l == 0) {
                        dp[r].add(tu);
                    } else {
                        for (String cau : dp[l]) {
                            dp[r].add(cau + " " + tu);
                        }
                    }
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> tuDien = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> rs = themDauCach(str, tuDien);
        
        for (String cau : rs) {
            System.out.println(cau);
        }
    }
}
