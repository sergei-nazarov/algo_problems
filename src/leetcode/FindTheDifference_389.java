package leetcode;

public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        return (char) (t.chars().sum()-s.chars().sum());
    }

    public static void main(String[] args) {
        evoke("abcd", "abcde");
        evoke("", "e");
        evoke("abcdabcd", "abbabcdcd");
    }

    static void evoke(String first, String second) {
        System.out.println(first + " " + second + " : "
                + new FindTheDifference_389().findTheDifference(first, second));
    }

}
