class Solution {
    public int minCostConnectPoints(int[][] points) {
           int n = points.length;

        // Create a min-heap to store edges along with their distances
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        // Calculate the Manhattan distance between all pairs of points and add to the heap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.offer(new int[]{i, j, distance});
            }
        }

        // Initialize variables for Union-Find (Disjoint Set Union)
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int minCost = 0;
        int edgeCount = 0;

        while (!minHeap.isEmpty() && edgeCount < n - 1) {
            int[] edge = minHeap.poll();
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            // If the two points are not already connected,
            // connect them and add the distance to the cost
            if (parentU != parentV) {
                parent[parentU] = parentV;
                minCost += distance;
                edgeCount++;
            }
        }

        return minCost;
    }
    
    // Helper function to find the root of a set using path compression
    private int find(int[] parent, int node) {
        if (parent[node] == -1) return node;
        return parent[node] = find(parent, parent[node]);
    }

}