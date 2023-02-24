package csp.sudoku;

import csp.Constraint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SudokuConstraint extends Constraint<Point, Integer> {

    public SudokuConstraint(List<Point> variables) {
        super(variables);
    }

    @Override
    public boolean satisfied(Map<Point, Integer> assignment) {
        List<Integer> integers = assignment.keySet().stream().filter(x -> variables.contains(x)).map(assignment::get).toList();
        return integers.size() == new HashSet<>(integers).size();
    }

}
