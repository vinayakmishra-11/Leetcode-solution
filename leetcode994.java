class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        // Add all rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[][] dir = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        int minutes = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {

                Pair p = q.poll();

                int row = p.row;
                int col = p.col;

                for (int[] d : dir) {

                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;
                        rotten = true;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }

            if (rotten)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}