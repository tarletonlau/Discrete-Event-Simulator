class DoneEvent implements ServerAssociatedEvent {
    private final double eventTime;
    private final Customer customer;
    private final int allocatedServerIndex;

    DoneEvent(Customer customer, int serverIndex) {
        this.eventTime = customer.endTime();
        this.customer = customer;
        this.allocatedServerIndex = serverIndex;
    }

    // ==========  Event interface ==================
    
    public double eventTime() {
        return this.eventTime;
    }

    public Pair<Shop, PQ<Event>> process(Shop shop, PQ<Event> eventQueue) {
        /* two actions
        1. remove DoneEvent from PQ - basically dont add anything
        2. keep a count of Done
        */

        //2. keep a count ? how?
        
        
        // 1.
        return new Pair<Shop, PQ<Event>>(shop, eventQueue);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Statistics updateStatistics(Statistics stats) {
        return stats.incrementServed();
    }

    // ==================================================

    public int getAllocatedServerIndex() {
        return this.allocatedServerIndex;
    }

    public String toString() {
        return String.format("%.3f %s done serving by %d", 
        this.eventTime, this.customer.toString(), this.allocatedServerIndex + 1);
    }
}
