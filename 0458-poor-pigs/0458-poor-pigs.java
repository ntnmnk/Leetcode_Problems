class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
             int max_time = minutesToTest / minutesToDie + 1;
        // Initialize the required minimum number of pigs...
        int req_pigs = 0;
        // To find the minimum number of pigs, find the minimum req_pigs such that Math.pow(max_time, req_pigs) >= buckets...
        while (Math.pow(max_time, req_pigs) < buckets)
            // Increment until it will be greater or equals to bucket...
            ++req_pigs;
        // Return the required minimum number of pigs...
        return req_pigs;

    }
}