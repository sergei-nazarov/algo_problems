package minimax.connect_four;

import minimax.Piece;

public enum C4Piece implements Piece {
    R,B,E; // E - empty

    @Override
    public C4Piece opposite() {
        return switch (this){
            case R -> C4Piece.B;
            case B -> C4Piece.R;
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

    @Override
    public String toString() {
        return switch (this){
            case R -> "O";
            case B -> "X";
            default -> " ";
        };
    }
}
