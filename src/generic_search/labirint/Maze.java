package generic_search.labirint;

import generic_search.Node;

import java.util.*;

import static generic_search.GenericSearch.*;

public class Maze {
    final int rows, columns;
    final MazeLocation start, goal;
    private final Cell[][] grid;

    public static void main(String[] args) throws InterruptedException {
        Maze m = new Maze(20, 20, new MazeLocation(1, 1), new MazeLocation(1, 19), 0.25);
        System.out.print(m);

        //Astars
        Node<MazeLocation> astars = aStar(m.start, m::goalTest, m::successors, m::manhattanDistance);
        printResult(m, astars);
        //В глубину
        Node<MazeLocation> dfs = dfs(m.start, m::goalTest, m::successors);
        printResult(m, dfs);
        //В ширину
        Node<MazeLocation> bfs = bfs(m.start, m::goalTest, m::successors);
        printResult(m, bfs);

    }

    private static void printResult(Maze m, Node<MazeLocation> bfs) {
        if (bfs == null) {
            System.out.println("Решения нет");
        } else {
            List<MazeLocation> path = nodeToPath(bfs);
            m.mark(path);
            System.out.println();
            System.out.println(m);
            m.clear(path);
        }
    }

    public boolean goalTest(MazeLocation t) {
        return goal.equals(t);
    }


    public double manhattanDistance(MazeLocation ml) {
        int xDist = Math.abs(ml.column - goal.column);
        int yDist = Math.abs(ml.row - goal.row);
        return xDist + yDist;
    }

    public double meuclidianDistance(MazeLocation ml) {
        int xDist = ml.column - goal.column;
        int yDist = ml.row - goal.row;
        return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
    }


    public Maze(int rows, int columns, MazeLocation start, MazeLocation goal, double sparseness) {
        this.rows = rows;
        this.columns = columns;
        this.start = start;
        this.goal = goal;
        grid = new Cell[rows][columns];
        for (Cell[] row : grid) {
            Arrays.fill(row, Cell.EMPTY);
        }
        randomlyFill(sparseness);
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;

    }

    public Maze() {
        this(10, 10, new MazeLocation(0, 0), new MazeLocation(9, 9), 0.2);
    }

    private void randomlyFill(double sparseness) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (Math.random() < sparseness) {
                    grid[row][column] = Cell.BLOCKED;
                }
            }
        }
    }



    public void mark(List<MazeLocation> path) {
        for (MazeLocation location : path) {
            grid[location.row][location.column] = Cell.PATH;
        }
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public void clear(List<MazeLocation> path) {
        for (MazeLocation location : path) {
            grid[location.row][location.column] = Cell.EMPTY;
        }
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public List<MazeLocation> successors(MazeLocation ml) {
        List<MazeLocation> locations = new ArrayList<>();
        if (ml.column + 1 < columns && grid[ml.row][ml.column + 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column + 1));
        }
        if (ml.column - 1 >= 0 && grid[ml.row][ml.column - 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column - 1));
        }
        if (ml.row + 1 < rows && grid[ml.row + 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row + 1, ml.column));
        }
        if (ml.row - 1 >= 0 && grid[ml.row - 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row - 1, ml.column));
        }

        return locations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                builder.append(cell.toString()).append("  ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public enum Cell {
        EMPTY(" "), BLOCKED("X"), START("S"), GOAL("G"), PATH("o");
        private final String code;

        Cell(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }
}
