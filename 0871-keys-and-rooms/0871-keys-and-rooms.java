class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
               int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }
}