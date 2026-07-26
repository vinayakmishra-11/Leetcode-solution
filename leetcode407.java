class Triplet {
    int row;
    int col;
    int height;

    Triplet(int r, int c, int h) {
        this.row = r;
        this.col = c;
        this.height = h;
    }
}

class Solution {
    public int trapRainWater(int[][] arr) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] v = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            v[i][0] = true;
            v[i][arr[0].length - 1] = true;
            pq.add(new Triplet(i, 0, arr[i][0]));
            pq.add(new Triplet(i, arr[0].length - 1, arr[i][arr[0].length - 1]));
        }

        for (int j = 0; j < arr[0].length; j++) {
            v[0][j] = true;
            v[arr.length - 1][j] = true;
            pq.add(new Triplet(0, j, arr[0][j]));
            pq.add(new Triplet(arr.length - 1, j, arr[arr.length - 1][j]));
        }
        int[][] dir = {
                { 0, 1 },
                { 1, 0 },
                { -1, 0 },
                { 0, -1 },
        };
        int water = 0;
        while (!pq.isEmpty()) {
            Triplet t = pq.poll();
            int r = t.row;
            int c = t.col;
            int h = t.height;
            for (int[] arr2 : dir) {
                int newRow = r + arr2[0];
                int newCol = c + arr2[1];

                if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length && !v[newRow][newCol]) {
                   // water += Math.max(h - arr[newRow][newCol], 0);
                    v[newRow][newCol] = true;
                   // pq.add(new Triplet(newRow, newCol, arr[newRow][newCol]));
                    water += Math.max(h - arr[newRow][newCol], 0);

                    pq.add(new Triplet(
                            newRow,
                            newCol,
                            Math.max(h, arr[newRow][newCol])));
                }
            }
        }
        return water;

    }
}