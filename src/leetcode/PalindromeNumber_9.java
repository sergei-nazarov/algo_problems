package leetcode;

public class PalindromeNumber_9 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x!=0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == x || reversed / 10 == x;
    }



    public static void main(String[] args) {
        System.out.println(0 + " " + new PalindromeNumber_9().isPalindrome(0));
        System.out.println(121 + " " + new PalindromeNumber_9().isPalindrome(121));
        System.out.println(122 + " " + new PalindromeNumber_9().isPalindrome(122));
        System.out.println(1221 + " " + new PalindromeNumber_9().isPalindrome(1221));

    }
}
