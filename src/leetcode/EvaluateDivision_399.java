package leetcode;

import java.util.*;

public class EvaluateDivision_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            var list = equations.get(i);
            var result = values[i];
            var a = list.get(0);
            var b = list.get(1);
            map.computeIfAbsent(a, _ -> new HashMap<>()).put(b, result);
            map.computeIfAbsent(b, _ -> new HashMap<>()).put(a, 1 / result);
        }
        Set<String> set = new HashSet<>();
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var query = queries.get(i);
            var s1 = query.get(0);
            var s2 = query.get(1);
            result[i] = dfs(map, set, s1, s2);
        }
        return result;
    }

    double dfs(Map<String, Map<String, Double>> map, Set<String> visited, String a, String b) {
        var s1map = map.get(a);
        var s2map = map.get(b);
        if (s1map == null || s2map == null) {
            return -1.0;
        } else if (a.equals(b)) {
            return 1.0;
        }
        var res = s1map.get(b);
        if (res != null) {
            return res;
        }
        double result = -1;
        visited.add(a);
        System.out.println(STR."\{a} \{b}");
        for (var candidate : s1map.keySet()) {
            if(!visited.contains(candidate)){
                result = dfs(map, visited, candidate, b);
                if (result != -1) {
                    double w = s1map.get(candidate);
                    result = w * result;
                    break;
                }

            }

        }
        visited.remove(a);
        if (result != -1) {
            s1map.put(b, result);
            s2map.put(a, 1 / result);
        }
        return result;
    }

    public static void main(String[] args) {
        new EvaluateDivision_399().calcEquation(List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5")),
                new double[]{3.0, 4.0, 5.0, 6.0}, List.of(List.of("x1", "x5")));
    }
}
