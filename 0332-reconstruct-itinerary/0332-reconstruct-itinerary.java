class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
             Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // Perform DFS starting from "JFK"
        dfs("JFK", graph, result);

        // Reverse the result to get the correct order
        Collections.reverse(result);

        return result;
    }

    private static void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, result);
        }

        result.add(airport);
    }
   
    }
