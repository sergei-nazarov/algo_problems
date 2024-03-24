package leetcode;

public class SubstringInReverse_3083 {
    public boolean isSubstringPresent(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            String str = s.substring(i, i + 2);
            if(s.contains(new StringBuilder(str).reverse().toString())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("leetcode"));
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("abcba"));
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("abcd"));
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("leafbcaef"));
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("legrtel"));
        System.out.println(new SubstringInReverse_3083().isSubstringPresent("qwertyewnmc"));


    }


}
