class LeaveEvent implements Event {
    private final double eventTime;
    private final Customer customer;

    LeaveEvent(Customer customer) {
        this.eventTime = customer.startTime();
        this.customer = customer;
    }

    // ================= Event Interface =================

    public double eventTime() {
        return customer.startTime();
    }

    public Pair<Shop, PQ<Event>> process(Shop shop, PQ<Event> eventQueue) {
        /* two actions
           1. remove LeaveEvent from PQ - basically dont add anything
           2. keep a count of Leave
         */

        //2. keep a count ? how?


        // 1.
        return new Pair<Shop, PQ<Event>>(shop, eventQueue);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Statistics updateStatistics(Statistics stats) {
        return stats.incrementLeft();
    }


    // =================================================

    public String toString() {
        return String.format("%.3f %s leaves", this.eventTime, this.customer.toString());
    }
}
