class Solution {
    public int countKDifference(int[] nums, int k) {
       Map<Integer,Integer> map=new HashMap<>();
       int total =0;
       for(int num:nums) {
           if(map.containsKey(num-k)){
               total+=map.get(num-k);
           }
           if(map.containsKey(num+k)){
               total+=map.get(num+k);
           }
           map.put(num, map.getOrDefault(num, 0) + 1);

       }
               return total;

    }
}