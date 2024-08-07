package leetcode;

import java.util.*;

public class WordLadderII_126 {

    private Set<String> set; // set will congtain the wordList
    private Queue<Node> q; // queue to bfs

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        set = new HashSet<>();
        q = new LinkedList<>();

        for (String s : wordList) set.add(s); //add wordList to set

        // if endWord is not in wordList return blank result as no possible path
        if (!set.contains(endWord)) return result;

        q.add(new Node(beginWord)); // add the beginNode

        while (!q.isEmpty()) {
            int size = q.size();
            // tempset to remove the used word all together after every Iteration
            Set<String> removeSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.name.equals(endWord)) {
                    result.add(cur.path); // match found add the path history to the result
                } else {
                    List<String> neighbours = getNeighbours(cur.name);
                    for (String n : neighbours) {
                        q.add(new Node(n, cur.path));
                        removeSet.add(n); // add the words getting used, later we will delete all.
                    }
                }
            }
            set.removeAll(removeSet); // remove the words used in this traversal
        }
        return result;
    }

    // generate the possible neighbours to traverse
    private List<String> getNeighbours(String word) {
        char[] ch = word.toCharArray();
        List<String> words = new ArrayList<>();
        // replace each char with from a to z
        // and check if thats a valid word
        // if valid add to neighbours list
        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            for (char j = 'a'; j <= 'z'; j++) {
                ch[i] = j;
                String newWord = new String(ch);
                if (set.contains(newWord)) words.add(newWord);
            }
            ch[i] = temp;
        }
        return words;
    }
}

// Node Class to contain the String word & traversal path
class Node {
    String name;
    LinkedList<String> path;

    // add the string word as name & add it to path as well
    public Node(String name) {
        this.name = name;
        this.path = new LinkedList<>();
        this.path.add(name);
    }

    // add the name, add path history from parent and then add the current as well.
    public Node(String name, LinkedList<String> path) {
        this.name = name;
        this.path = new LinkedList<>();
        this.path.addAll(path);
        this.path.add(name);
    }


    public static void main(String[] args) {
        System.out.println(new WordLadderII_126().findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//        System.out.println(new WordLadderII_126().findLadders("hot", "dog", List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
        String beginWord = "magic";
        String endWord = "pearl";
        List<String> wordList = Arrays.asList("flail", "halon", "lexus", "joint", "pears", "slabs", "lorie", "lapse", "wroth", "yalow", "swear", "cavil", "piety", "yogis", "dhaka", "laxer", "tatum", "provo", "truss", "tends", "deana", "dried", "hutch", "basho", "flyby", "miler", "fries", "floes", "lingo", "wider", "scary", "marks", "perry", "igloo", "melts", "lanny", "satan", "foamy", "perks", "denim", "plugs", "cloak", "cyril", "women", "issue", "rocky", "marry", "trash", "merry", "topic", "hicks", "dicky", "prado", "casio", "lapel", "diane", "serer", "paige", "parry", "elope", "balds", "dated", "copra", "earth", "marty", "slake", "balms", "daryl", "loves", "civet", "sweat", "daley", "touch", "maria", "dacca", "muggy", "chore", "felix", "ogled", "acids", "terse", "cults", "darla", "snubs", "boats", "recta", "cohan", "purse", "joist", "grosz", "sheri", "steam", "manic", "luisa", "gluts", "spits", "boxer", "abner", "cooke", "scowl", "kenya", "hasps", "roger", "edwin", "black", "terns", "folks", "demur", "dingo", "party", "brian", "numbs", "forgo", "gunny", "waled", "bucks", "titan", "ruffs", "pizza", "ravel", "poole", "suits", "stoic", "segre", "white", "lemur", "belts", "scums", "parks", "gusts", "ozark", "umped", "heard", "lorna", "emile", "orbit", "onset", "cruet", "amiss", "fumed", "gelds", "italy", "rakes", "loxed", "kilts", "mania", "tombs", "gaped", "merge", "molar", "smith", "tangs", "misty", "wefts", "yawns", "smile", "scuff", "width", "paris", "coded", "sodom", "shits", "benny", "pudgy", "mayer", "peary", "curve", "tulsa", "ramos", "thick", "dogie", "gourd", "strop", "ahmad", "clove", "tract", "calyx", "maris", "wants", "lipid", "pearl", "maybe", "banjo", "south", "blend", "diana", "lanai", "waged", "shari", "magic", "duchy", "decca", "wried", "maine", "nutty", "turns", "satyr", "holds", "finks", "twits", "peaks", "teems", "peace", "melon", "czars", "robby", "tabby", "shove", "minty", "marta", "dregs", "lacks", "casts", "aruba", "stall", "nurse", "jewry", "knuth");

        System.out.println(new WordLadderII_126().findLadders(beginWord, endWord, wordList));


    }


}
