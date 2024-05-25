package leetcode;

import java.util.*;

public class WordSearch_74 {

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1 || doStep(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean doStep(char[][] board, String word, int y, int x, int currentNum, int[][] visited) {
        if (currentNum == word.length() - 1) return true;
        visited[y][x] = 1;
        currentNum++;
        if (y + 1 < board.length && visited[y + 1][x] != 1 && word.charAt(currentNum) == board[y + 1][x] && doStep(board, word, y + 1, x, currentNum, visited)) {
            return true;
        } else if (y - 1 >= 0 && visited[y - 1][x] != 1 && word.charAt(currentNum) == board[y - 1][x] && doStep(board, word, y - 1, x, currentNum, visited)) {
            return true;
        } else if (x + 1 < board[0].length && visited[y][x + 1] != 1 && word.charAt(currentNum) == board[y][x + 1] && doStep(board, word, y, x + 1, currentNum, visited)) {
            return true;
        } else if (x - 1 >= 0 && visited[y][x - 1] != 1 && word.charAt(currentNum) == board[y][x - 1] && doStep(board, word, y, x - 1, currentNum, visited)) {
            return true;
        }
        visited[y][x] = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch_74().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println(new WordSearch_74().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));

        System.out.println(new WordSearch_74().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));
        System.out.println(new WordSearch_74().exist(new char[][]{
                {'a'}
        }, "a"));
        System.out.println(new WordSearch_74().exist(new char[][]{
                {'a'},
                {'a'},
        }, "aaa"));
        System.out.println(new WordSearch_74().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));

        System.out.println(new WordSearch_74().exist(new char[][]{
                {'A', 'a', 'a'},
                {'a', 'A', 'A'},
                {'A', 'a', 'a'},
                {'A', 'a', 'a'},
        }, "aaaaAaAa"));


    }
}
