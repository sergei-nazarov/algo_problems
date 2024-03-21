//package leetcode;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class GenerateParentheses_22 {
//
//    public List<String> generateParenthesis(int n) {
//        Set<String> result = new HashSet<>();
//        result.add("()");
//        for (int i = 1; i < n; i++) {
//            var newRes = new HashSet<String>();
//            for (String string : result) {
//                newRes.add(string + "()");
//                newRes.add("()" + string);
//                newRes.add("(" + string + ")");
//            }
//            result = newRes;
//        }
//        return new ArrayList<>(result);
//    }
//
//
//    public static void main(String[] args) {
//        evoke(1);
//        evoke(2);
//        evoke(3);
//        evoke(4);
//    }
//
//    static void evoke(int n) {
//        System.out.println(n + " : "
//                + new GenerateParentheses_22().generateParenthesis(n));
//    }
//
//}
