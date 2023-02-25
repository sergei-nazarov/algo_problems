package csp.sudoku;

import csp.CSP;
import csp.Constraint;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Sudoku {

    int rows = 9, columns = 9;
    int[][] grid = new int[rows][columns];

    public Sudoku() {
    }

    public void solve(Map<Point, Integer> startValues) {
        List<Point> points = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                points.add(new Point(row, column));
            }
        }
        HashMap<Point, List<Integer>> domain = new HashMap<>();
        for (Point point : points) {
            domain.put(point, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
        CSP<Point, Integer> csp = new CSP<>(points, domain);

        List<Constraint<Point, Integer>> constraints = new ArrayList<>();
        for (int column = 0; column < columns; column++) {
            int finalColumn = column;
            List<Point> variables = points.stream().filter(x -> x.column == finalColumn).toList();
            constraints.add(new SudokuConstraint(variables));
        }
        for (int row = 0; row < rows; row++) {
            int finalRow = row;
            List<Point> variables = points.stream().filter(x -> x.row == finalRow).toList();
            constraints.add(new SudokuConstraint(variables));
        }

        for (int row = 0; row < 9; row = row + 3) {
            for (int column = 0; column < 9; column = column + 3) {
                int finalRow = row;
                int finalColumn = column;
                List<Point> variables = points.stream()
                        .filter(x -> x.row >= finalRow && x.row < finalRow + 3)
                        .filter(x -> x.column >= finalColumn && x.column < finalColumn + 3)
                        .toList();
                constraints.add(new SudokuConstraint(variables));
            }
        }

        constraints.forEach(csp::addConstraint);
        printGrid(startValues);
        Map<Point, Integer> solution = csp.backtrackingSearch(startValues);
        System.out.println();
        if (solution == null) {
            System.out.println("No solution");
        } else {
            printGrid(solution);
        }
    }

    public void solve() {
        solve(new HashMap<>());
    }

    private void printGrid(Map<Point, Integer> solution) {
        for (Point point : solution.keySet()) {
            grid[point.row][point.column] = solution.get(point);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(Arrays.toString(grid[i]).replace('0','-')).append(System.lineSeparator());
        }
        System.out.println(sb);
    }


    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        HashMap<Point, Integer> startValues = new HashMap<>();
        startValues.put(new Point(0, 0), 4);
        startValues.put(new Point(0, 2), 6);
        startValues.put(new Point(0, 8), 8);

        startValues.put(new Point(1, 0), 5);
        startValues.put(new Point(1, 5), 3);
        startValues.put(new Point(1, 6), 6);
        startValues.put(new Point(1, 7), 4);

        startValues.put(new Point(2, 3), 4);
        startValues.put(new Point(2, 8), 7);

        startValues.put(new Point(3, 2), 5);
        startValues.put(new Point(3, 3), 8);
        startValues.put(new Point(3, 6), 1);
        startValues.put(new Point(3, 7), 2);

        startValues.put(new Point(4, 0), 3);
        startValues.put(new Point(4, 4), 9);

        startValues.put(new Point(5, 8), 6);

        startValues.put(new Point(6, 1), 2);
        startValues.put(new Point(6, 5), 8);

        startValues.put(new Point(7, 2), 1);
        startValues.put(new Point(7, 3), 2);
        startValues.put(new Point(7, 6), 4);
        startValues.put(new Point(7, 7), 5);

        startValues.put(new Point(8, 7), 7);


        LocalDateTime now = LocalDateTime.now();
        sudoku.solve(startValues);
        System.out.println(Duration.between(now, LocalDateTime.now()).toSeconds());
    }

}

