class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void bfs(int r, int c, char[][] board) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        board[r][c] = '#';

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {

            Pair p = q.poll();

            for (int[] d : dir) {

                int newRow = p.row + d[0];
                int newCol = p.col + d[1];

                if (newRow >= 0 &&
                    newRow < board.length &&
                    newCol >= 0 &&
                    newCol < board[0].length &&
                    board[newRow][newCol] == 'O') {

                    board[newRow][newCol] = '#';
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public void solve(char[][] board) {

        if (board == null || board.length == 0) return;

        int n = board.length;
        int m = board[0].length;

        // First column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                bfs(i, 0, board);

            if (board[i][m - 1] == 'O')
                bfs(i, m - 1, board);
        }

        // First row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                bfs(0, j, board);

            if (board[n - 1][j] == 'O')
                bfs(n - 1, j, board);
        }

        // Convert remaining O -> X
        // Restore # -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}