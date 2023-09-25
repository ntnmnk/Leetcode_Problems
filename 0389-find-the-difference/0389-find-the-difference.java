class Solution {
    public char findTheDifference(String s, String t) {
      char cs[]=s.toCharArray();
      char ct[]=t.toCharArray();
          char result = 0;


      for(char c:cs)  
                result ^= c;

      for(char c:ct)
           result^=c;

      return result;

    }
}