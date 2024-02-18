package leetcode;

import java.util.Arrays;

public class FirstOccurrence_28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean finished = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
//                    i = i + j;
                    finished = false;
                    break;
                }
            }
            if (finished) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        evoke("sadbutsad", "sad");
//        evoke("sadbutsad", "but");
//        evoke("leetcode", "leeto");
        evoke("mississippi", "issip");
        evoke("mississippi", "issipi");


    }

    static void evoke(String haystack, String needle) {
        System.out.println(haystack + " " + needle + "' : "
                + new FirstOccurrence_28().strStr(haystack, needle));
    }


}
