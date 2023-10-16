class Solution {
    public List<Integer> getRow(int rowIndex) {
              List<Integer> row = new ArrayList<>();
        row.add(1); // The first element of each row is always 1.
        
        for (int i = 1; i <= rowIndex; i++) {
            // Calculate the next element using the previous row.
            for (int j = row.size() - 2; j >= 0; j--) {
                row.set(j + 1, row.get(j) + row.get(j + 1));
            }
            row.add(1); // The last element of each row is always 1.
        }
        
        return row;
  
    }
}