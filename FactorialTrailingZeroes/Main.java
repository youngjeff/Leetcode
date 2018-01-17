package FactorialTrailingZeroes;

public class Main {
    public static void main(String[] args){
        Solution sl = new Solution();
        System.out.print(sl.trailingZeroes(1808548329));
    }
}
class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}