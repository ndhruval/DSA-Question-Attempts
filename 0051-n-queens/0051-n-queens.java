
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append('.');
            }
            board.add(s.toString());
        }
        backtrack(0, n, board, ans);
        return ans;
    }

    private void backtrack(int col, int n, List<String> board, List<List<String>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (validate(board, row, col)) {
                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                board.set(row, new String(rowChars));

                backtrack(col + 1, n, board, ans);

                rowChars = board.get(row).toCharArray();
                rowChars[col] = '.';
                board.set(row, new String(rowChars));
            }
        }
    }

    private boolean validate(List<String> board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.size()) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}