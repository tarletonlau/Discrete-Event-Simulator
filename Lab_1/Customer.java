class Customer implements Time {
    private final double arrivalTime;
    private final double serviceTime;

    Customer(double arrivalTime, double serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    // Time interface
    public double startTime() {
        return this.arrivalTime;
    }


    public double endTime() {
        return this.arrivalTime + this.serviceTime;
    }


    public String toString() {
        return "Arrival Time: " + this.arrivalTime + "\nService Time: " + this.serviceTime;
    }
}
