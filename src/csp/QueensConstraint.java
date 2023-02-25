package csp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QueensConstraint extends Constraint<Integer, Integer> {

    public QueensConstraint(List<Integer> variables) {
        super(variables);
    }

    @Override
    public boolean satisfied(Map<Integer, Integer> assignment) {
        for (Integer variable1 : assignment.keySet()) {
            for (Integer variable2 : assignment.keySet()) {
                if (Objects.equals(variable1, variable2)) {
                    continue;
                } else if (Objects.equals(assignment.get(variable1), assignment.get(variable2))) {
                    return false;
                } else if (Math.abs(assignment.get(variable1) - assignment.get(variable2)) == Math.abs(variable1 - variable2)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        List<Integer> columns = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Integer, List<Integer>> rows = new HashMap<>();
        for (int colum : columns) {
            rows.put(colum, List.of(1, 2, 3, 4, 5, 6, 7, 8));
        }
        CSP<Integer, Integer> csp = new CSP<>(columns, rows);
        csp.addConstraint(new QueensConstraint(List.of(1, 2, 3, 4, 5, 6, 7, 8)));

        Map<Integer, Integer> solution = csp.backtrackingSearch();
        if (solution == null) {
            System.out.println("No solution");
        } else {
            System.out.println(solution);
        }
    }
}
