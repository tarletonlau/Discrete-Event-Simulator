class Server implements Time {
    private final double serverAvailableTime;

    Server(double serverAvailableTime) {
        this.serverAvailableTime = serverAvailableTime;
    }

    // ====================== METHODS =================================================
    // Server used by customer
    public Server use(Customer customer) {
        return new Server(customer.endTime());
    }

    /* Checking if server is free
    if customer arrival time is >= to server available time => server is free to server
    */
    public boolean canServe(Customer customer) {
        return customer.startTime() >= this.serverAvailableTime;
    }

    // =================================================================================

    // Time interface
    public double startTime() {
        return this.serverAvailableTime;
    }

    public String toString() {
        return String.format("%.3f", this.serverAvailableTime);
    }

}




