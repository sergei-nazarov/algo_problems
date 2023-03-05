package minimax.connect_four;

import minimax.Board;
import minimax.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class C4Board implements Board<Integer> {

    private static final int NUM_ROWS = 6;
    private static final int NUM_COLUMNS = 7;
    private static final int SEGMENT_LENGTH = 4;

    private C4Piece[][] position;
    private C4Piece turn;
    private int[] columnCount; //количество фишек в каждом столбце
    private List<C4Location[]> SEGMENTS = generateSegments();

    public C4Board() {
        position = new C4Piece[NUM_COLUMNS][NUM_ROWS];
        for (C4Piece[] col : position) {
            Arrays.fill(col, C4Piece.E);
        }
        columnCount = new int[NUM_COLUMNS];
        turn = C4Piece.B;
    }

    public C4Board(C4Piece[][] position, C4Piece turn) {
        this.position = position;
        columnCount = new int[NUM_COLUMNS];
        for (int c = 0; c < NUM_COLUMNS; c++) {
            int piecesInCount = 0;
            for (int r = 0; r < NUM_ROWS; r++) {
                if (position[c][r] != C4Piece.E) {
                    piecesInCount++;
                }
            }
            columnCount[c] = piecesInCount;
        }
        this.turn = turn;
    }

    private List<C4Location[]> generateSegments() {
        ArrayList<C4Location[]> segments = new ArrayList<>();
        //columns
        for (int c = 0; c < NUM_COLUMNS; c++) {
            for (int r = 0; r <= NUM_ROWS - SEGMENT_LENGTH; r++) {
                C4Location[] bl = new C4Location[SEGMENT_LENGTH];
                for (int i = 0; i < SEGMENT_LENGTH; i++) {
                    bl[i] = new C4Location(c, r + i);
                }
                segments.add(bl);
            }
        }

        //rows
        for (int c = 0; c <= NUM_COLUMNS - SEGMENT_LENGTH; c++) {
            for (int r = 0; r < NUM_ROWS; r++) {
                C4Location[] bl = new C4Location[SEGMENT_LENGTH];
                for (int i = 0; i < SEGMENT_LENGTH; i++) {
                    bl[i] = new C4Location(c + i, r);
                }
                segments.add(bl);
            }
        }
//diagonals
        for (int c = 0; c <= NUM_COLUMNS - SEGMENT_LENGTH; c++) {
            for (int r = 0; r <= NUM_ROWS - SEGMENT_LENGTH; r++) {
                C4Location[] bl = new C4Location[SEGMENT_LENGTH];
                for (int i = 0; i < SEGMENT_LENGTH; i++) {
                    bl[i] = new C4Location(c + i, r + i);
                }
                segments.add(bl);
            }
        }
//diagonals
        for (int c = NUM_COLUMNS - SEGMENT_LENGTH; c >= 0; c--) {
            for (int r = SEGMENT_LENGTH - 1; r < NUM_ROWS; r++) {
                C4Location[] bl = new C4Location[SEGMENT_LENGTH];
                for (int i = 0; i < SEGMENT_LENGTH; i++) {
                    bl[i] = new C4Location(c + i, r - i);
                }
                segments.add(bl);
            }
        }
        return segments;
    }

    @Override
    public C4Piece getTurn() {
        return turn;
    }

    @Override
    public C4Board move(Integer location) {
        C4Piece[][] temporaryPosition = Arrays.copyOf(position, position.length);
        for (int col = 0; col < NUM_COLUMNS; col++) {
            temporaryPosition[col] = Arrays.copyOf(position[col], position[col].length);
        }
        temporaryPosition[location][columnCount[location]] = turn;
        return new C4Board(temporaryPosition, turn.opposite());
    }

    @Override
    public List<Integer> getLegalMoves() {
        List<Integer> legalMoves = new ArrayList<>();
        for (int i = 0; i < NUM_COLUMNS; i++) {
            if (columnCount[i] < NUM_ROWS) {
                legalMoves.add(i);
            }
        }
        return legalMoves;
    }

    @Override
    public boolean isWin() {
        for (C4Location[] segment : SEGMENTS) {
            int blackCount = countSegment(segment, C4Piece.B);
            int redCount = countSegment(segment, C4Piece.R);
            if (blackCount == SEGMENT_LENGTH || redCount == SEGMENT_LENGTH) {
                return true;
            }
        }
        return false;
    }

    private int countSegment(C4Location[] segment, C4Piece colour) {
        int count = 0;
        for (C4Location location : segment) {
            if (position[location.column][location.row] == colour) {
                count++;
            }
        }
        return count;
    }

    @Override
    public double evaluate(Piece player) {
        double total = 0.0;
        for (C4Location[] location : SEGMENTS) {
            total += evaluateSegment(location, turn);
        }
        return total;
    }

    private double evaluateSegment(C4Location[] segment, Piece player) {
        int blackCount = countSegment(segment, C4Piece.B);
        int redCount = countSegment(segment, C4Piece.R);
        if (blackCount > 0 && redCount > 0) {
            return 0;
        }
        int count = Math.max(blackCount, redCount);
        double score = 0;
        if (count == 2) {
            score = 1.0;
        } else if (count == 3) {
            score = 100.0;
        } else if (count == 4) {
            score = 1000000.0;
        }
        C4Piece color = (redCount > blackCount) ? C4Piece.R : C4Piece.B;
        if (color != player) {
            return -score;
        }
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int r = 0; r < NUM_COLUMNS; r++) {
            sb.append(r).append("/");
        }
        sb.append(System.lineSeparator());
        for (int r = NUM_ROWS - 1; r >= 0; r--) {
            sb.append("|");
            for (int c = 0; c < NUM_COLUMNS; c++) {
                sb.append(position[c][r].toString());
                sb.append("|");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
