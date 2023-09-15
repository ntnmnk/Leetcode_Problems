class Solution {
    public int findMinDifference(List<String> timePoints) {
            // Convert time strings to minutes
        List<Integer> timeInMinutes = new ArrayList<>();
        for (String time : timePoints) {
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3));
            int totalMinutes = hours * 60 + minutes;
            timeInMinutes.add(totalMinutes);
        }

        // Sort the time points in ascending order
        Collections.sort(timeInMinutes);

        // Calculate the minimum difference between adjacent time points
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < timeInMinutes.size(); i++) {
            int diff = timeInMinutes.get(i) - timeInMinutes.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }

        // Calculate the minimum difference considering the circular nature of time
        int circularDifference = 24 * 60 - (timeInMinutes.get(timeInMinutes.size() - 1) - timeInMinutes.get(0));
        minDifference = Math.min(minDifference, circularDifference);

        return minDifference;
    
    }
}