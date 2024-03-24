package leetcode;

public class RepeatedSubstringPattern_459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int partLength = 1; partLength <= s.length() / 2; partLength++) {
            String substring = s.substring(0, partLength);
            int counter = 0;
            if (s.length() % partLength != 0) {
                continue;
            }
            int partCount = s.length() / partLength;

            for (int j = 0; j < partCount; j++) {
                if (s.substring(j * partLength, j * partLength + partLength).equals(substring)) {
                    counter++;
                } else break;
            }
            if (counter == partCount) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("aabaaba"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("abac"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("bb"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("abab"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("abcabc"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("ababc"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("ababab"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("babbabbabbabbab"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("zzz"));
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("ab"));


    }

}
