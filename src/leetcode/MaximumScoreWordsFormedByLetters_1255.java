package leetcode;

public class MaximumScoreWordsFormedByLetters_1255 {
    int result2 = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letters2 = new int[26];
        for (char c : letters) {
            letters2[c - 'a']++;
        }
        helper(words, letters2, score, 0, 0);
        return result2;
    }

    public void helper(String[] words, int[] letters, int[] score, int cur, int result) {
        if (cur == words.length)
            return;
        // not take
        helper(words, letters, score, cur + 1, result);

        // try take
        String word = words[cur];
        int i;
        boolean canTake = true;
        int sc = 0;
        for (i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (letters[c] > 0) {
                letters[c]--;
                sc += score[c];
            } else {
                canTake = false;
                break;
            }
        }
        if (canTake) {
            System.out.println("result:" + result + " word " + word + " can take " + canTake + " sc " + sc);
            result += sc;

            result2 = Math.max(result, result2);

            helper(words, letters, score, cur + 1, result);
            for (i = 0; i < word.length(); i++) {
                letters[word.charAt(i) - 'a']++;
            }

        } else {
            System.out.println("result:" + result + " word " + word + " can take " + canTake);
            for (int j = i - 1; j >= 0; j--) {
                int c = word.charAt(j) - 'a';
                letters[c]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumScoreWordsFormedByLetters_1255().maxScoreWords(new String[]{"baaa", "aacc", "ccbc", "da", "dbbc"},
                new char[]{'a', 'a', 'a', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'}, new int[]{9, 4, 10, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

}
