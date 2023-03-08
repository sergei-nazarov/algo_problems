package minimax;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Mimimax {

    public static <Move> double minimax(Board<Move> board, Boolean maximizing, Piece originalPlayer, int maxDepth) {

        if (board.isWin() || board.isDraw() || maxDepth == 0) {
            return board.evaluate(originalPlayer);
        }
        if (maximizing) {
            double bestEval = Double.NEGATIVE_INFINITY;
            for (Move move : board.getLegalMoves()) {
                double result = minimax(board.move(move), false, originalPlayer, maxDepth - 1);
                bestEval = Math.max(result, bestEval);
            }
            return bestEval;
        } else {
            double worstEval = Double.POSITIVE_INFINITY;
            for (Move move : board.getLegalMoves()) {
                double result = minimax(board.move(move), true, originalPlayer, maxDepth - 1);
                worstEval = Math.min(result, worstEval);
            }
            return worstEval;
        }
    }

    public static <Move> Move findBestMove(Board<Move> board, int maxDepth) {
        return findBestMove(board, maxDepth, false);
    }

    public static <Move> Move findBestMove(Board<Move> board, int maxDepth, boolean optimize) {
        FourFunction<Double, Board<Move>, Boolean, Piece, Integer> algorithm;
        if (optimize) {
            algorithm = Mimimax::alphabeta;
        } else {
            algorithm = Mimimax::minimax;
        }
        double bestEval = Double.NEGATIVE_INFINITY;
        Move bestMove = null;
        for (Move move : board.getLegalMoves()) {
            double result = algorithm.apply(board.move(move), false, board.getTurn(), maxDepth);
            if (result > bestEval) {
                bestMove = move;
                bestEval = result;
            }
        }
        return bestMove;
    }

    public static <Move> double alphabeta(Board<Move> board, Boolean maximizing,
                                          Piece originalPlayer, int maxDepth) {
        return alphabeta(board, maximizing,
                originalPlayer, maxDepth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static <Move> double alphabeta(Board<Move> board, Boolean maximizing, Piece originalPlayer, int maxDepth, double alpha, double beta) {
        if (board.isWin() || board.isDraw() || maxDepth == 0) {
            return board.evaluate(originalPlayer);
        }
        if (maximizing) {
            for (Move move : board.getLegalMoves()) {
                alpha = Math.max(alpha, alphabeta(board.move(move), false, originalPlayer, maxDepth - 1, alpha, beta));
                if (beta <= alpha) break;
            }
            return alpha;
        } else {
            for (Move move : board.getLegalMoves()) {
                beta = Math.min(beta, alphabeta(board.move(move), true, originalPlayer, maxDepth - 1));
                if (beta <= alpha) break;
            }
            return beta;
        }
    }

    interface FourFunction<RESULT, A, B, C, D> {
        RESULT apply(A a, B b, C c, D d);
    }

}
