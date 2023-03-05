package minimax.tic_tac_toe;

import minimax.Board;
import minimax.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TTTBoard implements Board<Integer> {
    private static final int NUM_SQUARES = 9;
    private TTTPiece[] position;
    private TTTPiece turn;

    public TTTBoard(TTTPiece[] position, TTTPiece turn) {
        this.position = position;
        this.turn = turn;
    }

    public TTTBoard() {
        turn = TTTPiece.X;
        position = new TTTPiece[NUM_SQUARES];
        Arrays.fill(position, TTTPiece.E);
    }

    @Override
    public Piece getTurn() {
        return turn;
    }

    @Override
    public TTTBoard move(Integer location) {
        TTTPiece[] tempBoard = Arrays.copyOf(position, position.length);
        tempBoard[location] = turn;
        return new TTTBoard(tempBoard, turn.opposite());
    }

    @Override
    public List<Integer> getLegalMoves() {
        return IntStream.range(0, position.length).filter(x -> position[x].equals(TTTPiece.E)).boxed().toList();
    }

    @Override
    public boolean isWin() {
        return checkPose(0, 1, 2) || checkPose(3, 4, 5) || checkPose(6, 7, 8) ||
                checkPose(0, 3, 6) || checkPose(1, 4, 7) || checkPose(2, 5, 8) ||
                checkPose(0, 4, 8) || checkPose(2, 4, 6);
    }

    @Override
    public double evaluate(Piece player) {
        if (isWin() && turn == player) {
            return -1.0;
        } else if (isWin() && turn != player) {
            return 1;
        }
        return 0;
    }

    private boolean checkPose(int p0, int p1, int p2) {
        return position[p0] == position[p1] && position[p0] == position[p2] && position[p0] != TTTPiece.E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                sb.append(position[row * 3 + column].toString());
                if (column != 2) sb.append(" | ");
            }
            sb.append(System.lineSeparator());
            if (row != 2) {
                sb.append("--------");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
