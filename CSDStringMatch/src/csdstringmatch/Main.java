/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdstringmatch;

/**
 *
 * @author tranp
 */
public class Main {

    int MatchBr(String s, String p) {
        for (int i = 0; i < s.length() - p.length(); i++) {
            int j = 0;
            while (j < p.length() && p.charAt(j) == s.charAt(i + j)) {
                j++;
                if (j == p.length()) {
                    return i;
                }
            }

        }
        return -1;
    }

    int[] lps(String p) {
        int m = p.length();
        int[] lp = new int[m];
        int len = 0;
        int i = 1;
        lp[0] = 0;
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                i++;
                lp[len] = len;
            } else {
                if (len != 0) {
                    len = lp[len - 1];
                } else {
                    lp[i] = len;
                    i++;
                }
            }
        }
        return lp;
    }

    void kmp(String s, String p) {
        int n = s.length();
        int m = p.length();
        int lp[] = new int[m];
        lp = lps(s); // compute the lps array
        int i = 0, j = 0;
        while (i < n) {
            if (p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(p + " is found in " + s + " at " + (i - j));
                j = lp[j - 1]; // try to find another substring;
            } else {
                if (i < n && p.charAt(j) != s.charAt(i)) {
                    if (j != 0) {
                        j = lp[j - 1];
                    } else {
                        i = i + 1;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Main mn = new Main();
        String s = "abcdef";
        String p = "cde";
        int index = mn.MatchBr(s, p);
        if (index == -1) {
            System.out.println(p + " does not match " + s);
        } else {
            System.out.println(p + " matches with " + s + " at " + index);
        }
        
        mn.kmp(s, p);
    }

}
