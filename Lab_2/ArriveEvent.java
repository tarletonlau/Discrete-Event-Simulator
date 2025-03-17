class ArriveEvent implements Event {
    private final double eventTime;
    private final Customer customer;

    ArriveEvent(Customer customer) {
        this.eventTime = customer.startTime();
        this.customer = customer;
    }

    // ==========  Event interface ==================

    public double eventTime() {
        return this.eventTime;
    }

    public Pair<Shop, PQ<Event>> process(Shop shop, PQ<Event> eventQueue) {
        double time = this.eventTime;
        int availableServerIndex = shop.findAvailableServerIndex(time);

        if (availableServerIndex >= 0) {

            // add serveEvent to EventQueue
            eventQueue = eventQueue.add(new ServeEvent(this.customer,availableServerIndex));
            return new Pair<Shop, PQ<Event>>(shop, eventQueue);
        } else {

            // add LeaveEvent to EventQueue
            eventQueue = eventQueue.add(new LeaveEvent(this.customer));
            return new Pair<Shop, PQ<Event>>(shop, eventQueue);
        }
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Statistics updateStatistics(Statistics stats) {
        return stats;
    }


    // ==============================================

    public String toString() {
        return String.format("%.3f %s arrives", this.eventTime, this.customer.toString());
    }
}
