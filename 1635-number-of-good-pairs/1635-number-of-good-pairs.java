class Solution {
    public int numIdenticalPairs(int[] nums) {
    Map<Integer,Integer> map =new HashMap<>();
    int goodpairs=0;
    for(int num:nums)    {
        int count=map.getOrDefault(num,0);
        goodpairs+=count;
        map.put(num,count+1);
    }
    return goodpairs;
    }
}