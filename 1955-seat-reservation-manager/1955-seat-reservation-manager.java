class SeatManager {
       private int n;
    private TreeSet<Integer> availableSeats;

    public SeatManager(int n) {
        this.n = n;
        availableSeats = new TreeSet<>();
        for (int seatNumber = 1; seatNumber <= n; seatNumber++) {
            availableSeats.add(seatNumber);
        }
    }

    public int reserve() {
        if (!availableSeats.isEmpty()) {
            int seatToReserve = availableSeats.first();
            availableSeats.remove(seatToReserve);
            return seatToReserve;
        }
        return -1; // No available seats.
    }

    public void unreserve(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= n) {
            availableSeats.add(seatNumber);
        }
    }

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */