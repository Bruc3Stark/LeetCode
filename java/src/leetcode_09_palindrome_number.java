class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}

public class leetcode_09_palindrome_number {
    public static void main(String[] args) {
        // ======= Test Case =======
        int x = 121;
        // ====== Driver Code ======
        Solution slt = new Solution();
        System.out.println(slt.isPalindrome(x));
    }
}