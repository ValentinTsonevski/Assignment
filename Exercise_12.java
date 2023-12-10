public class Exercise_12 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, 0, i, 8)) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (!isValid(board, 0, j, 8, j)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int startRow = i * 3;
                int startCol = j * 3;
                int endRow = i * 3 + 2;
                int endCol = j * 3 + 2;

                if (!isValid(board, startRow, startCol, endRow, endCol)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int startRow, int startCol, int endRow, int endCol) {
        boolean[] seen = new boolean[10];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                char current = board[i][j];

                if (current == '.') {
                    continue;
                }

                int digit = current - '0';

                if (seen[digit]) {
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }
}
