package minimax;

public enum TTTPiece implements Piece{
    X,O,E // E - empty
    ;

    @Override
    public TTTPiece opposite() {
        return switch (this){
            case X -> TTTPiece.O;
            case O -> TTTPiece.X;
            default -> throw new IllegalStateException("Unexpected value: " + this);
        };
    }

    @Override
    public String toString() {
        return switch (this){
            case X -> "X";
            case O -> "O";
            default -> " ";
        };
    }
}
