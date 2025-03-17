class Server implements Time {
    private final double serverAvailableTime;

    Server(double serverAvailableTime) {
        this.serverAvailableTime = serverAvailableTime;
    }

    public Server use(Customer customer) {
        return new Server(customer.endTime());
    }

    public double startTime() {
        return this.serverAvailableTime;
    }

    public String toString() {
        return "(" + this.serverAvailableTime + ")";
    }
}


