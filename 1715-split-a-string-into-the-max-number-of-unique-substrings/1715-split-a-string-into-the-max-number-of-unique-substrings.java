class Solution {
    public int maxUniqueSplit(String s) {
              return backtrack(s, new HashSet<>(), 0);
    }

    private int backtrack(String s, Set<String> path, int start) {
        if (start == s.length()) {
            return path.size();
        }

        int maxSplits = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            String candidate = s.substring(start, end);
            if (!path.contains(candidate)) {
                path.add(candidate);
                int splits = backtrack(s, path, end);
                maxSplits = Math.max(maxSplits, splits);
                path.remove(candidate);
            }
        }

        return maxSplits;
  
    }
}