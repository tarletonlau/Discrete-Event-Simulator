class Customer implements Time {
    private final double arrivalTime;
    private final double serviceTime;
    private final int id;

    Customer(double arrivalTime, double serviceTime, Integer id) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.id = id;
    }

    // Time interface
    public double startTime() {
        return this.arrivalTime;
    }

    public double endTime() {
        return this.arrivalTime + this.serviceTime;
    }

    public String toString() {
        return String.format("%d",this.id);
    }
}
