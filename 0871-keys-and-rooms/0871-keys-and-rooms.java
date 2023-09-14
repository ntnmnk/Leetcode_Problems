class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Set<Integer> keys = new HashSet<>();
        keys.add(0);
        
        while (!keys.isEmpty()) {
            int room = keys.iterator().next();
            keys.remove(room);
            
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    keys.add(key);
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