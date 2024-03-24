package leetcode;

import javax.sound.sampled.Line;

public class TicTacToe_1275 {
    public String tictactoe(int[][] moves) {
        int[][] field = new int[3][3];
        for (int i = 0; i < moves.length; i += 2) {
            field[moves[i][0]][moves[i][1]] = 1;
        }
        for (int i = 1; i < moves.length; i += 2) {
            field[moves[i][0]][moves[i][1]] = 2;

        }
        for (int i = 0; i < field.length; i++) {
            int[] ints = field[i];
            if ((ints[0] == 1 || ints[0] == 2) && ints[0] == ints[1] && ints[1] == ints[2]) {
                if (ints[0] == 1) return "A";
                else return "B";
            }
            if ((field[0][i] == 1 || field[0][i] == 2) && (field[0][i] == field[1][i] && field[1][i] == field[2][i])) {
                if (field[0][i] == 1) return "A";
                else return "B";
            }
            if ((field[1][1] == 1 || field[1][1] == 2)
                    && (field[0][0] == field[1][1] && field[1][1] == field[2][2] || (field[0][2] == field[1][1] && field[1][1] == field[2][0]))) {
                if (field[1][1] == 1) return "A";
                else return "B";
            }
        }
        if (moves.length != 9) {
            return "Pending";
        }
        return "Draw";
    }

    public static void main(String[] args) {
//        System.out.println(new TicTacToe_1275().tictactoe(new int[][]{{
//                0, 0
//        }, {
//                2, 0
//        }, {
//                1, 1
//        }, {
//                2, 1
//        }, {
//                2, 2
//        }
//        }));

//        System.out.println(new TicTacToe_1275().tictactoe(new int[][]{
//                {2, 0},
//                {1, 1},
//                {0, 2},
//                {2, 1},
//                {1, 2},
//                {1, 0},
//                {0, 0},
//                {0, 1}
//        }));

        System.out.println(new TicTacToe_1275().tictactoe(new int[][]{
                new int[]{2, 1},
                new int[]{2, 0},
                new int[]{2, 2},
                new int[]{1, 1},
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 0},
                new int[]{1, 2}
        }));
    }
}
