class ServeEvent implements ServerAssociatedEvent {
    private final double eventTime;
    private final Customer customer;
    private final int allocatedServerIndex;

    ServeEvent(Customer customer, int serverIndex) {
        this.eventTime = customer.startTime();
        this.customer = customer;
        this.allocatedServerIndex = serverIndex;
    }

    // ==========  Event interface ==================
    public double eventTime() {
        return this.eventTime;
    }

    public Pair<Shop, PQ<Event>> process(Shop shop, PQ<Event> eventQueue) {

        /* two process to complete
           1. update shop with served server - serverAvailTime = customer.endTime()
           2. add DoneEvent to eventQueue
         */

        // updating shop
        Server updatedServer = new Server(this.customer.endTime());
        ImList<Server> currServers = shop.getServers();
        ImList<Server> updatedServers = currServers.set(
                this.allocatedServerIndex, updatedServer);

        shop = new Shop(updatedServers);

        // adding DoneEvent to eventQueue
        eventQueue = eventQueue.add(new DoneEvent(this.customer,this.allocatedServerIndex));

        return new Pair<Shop, PQ<Event>>(shop,eventQueue);
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Statistics updateStatistics(Statistics stats) {
        return stats;
    }

    // ================================================

    public int getAllocatedServerIndex() {
        return this.allocatedServerIndex;
    }

    public String toString() {
        return String.format("%.3f %s serves by %d", 
                this.eventTime, this.customer.toString(), this.allocatedServerIndex + 1);
    }
}

