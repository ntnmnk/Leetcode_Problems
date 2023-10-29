class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
          int test_val = minutesToTest/minutesToDie;
        int count=0;
        
        while( Math.pow(test_val+1,count) < buckets ){
            count++;
        }
        
        return count;
    


    }
}