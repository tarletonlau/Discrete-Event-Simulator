class WaitEvent extends Event {

    private final Server allocatedServer;
    private final boolean firstTimeInQueue;

    WaitEvent(Customer customer, Server server, double eventTime, boolean firstTimeInQueue) {
        super(customer,eventTime);
        this.allocatedServer = server;
        this.firstTimeInQueue = firstTimeInQueue;
    }

    /*
       function of WaitEvent
       waitevent is tied to customer
       waitevent is tied to a server
       waitevent has an event time of customer arrival time

       variables:
       - hold the event time
       - hold the customer
       - hold the allocated server

       process method
       - arriveevent creates a new waitevent

       - waitevent will be at the front of the queue when created
       1. waitevent will create a serveevent with event time of server next avail time
       - update the server with the current server avail time + customer service time

       2. update counter for wait time
     */

    // ========================  Event interface ==========================

    @Override
    public Statistics updateStatistics(Statistics stats) {
        return stats;
    }

    // ======================== Main logic ==========================


    /*
    get server from shop
    get server avail time

    if customer is front of queue
        if server is selfcheckout
            server to return is nearest selfcheckout
        else,
            return same server

        return a serveevent (with updated server)

    else,
        return waitevent at server next avail time (same server)



    get updatedserver

    if first time waiting,
        generate new waitevent
    else,



 */
    @Override
    public Pair<Shop,Event> process(Shop shop) {
        Event nextEvent;
        Server updatedServer = shop.getServer(this.allocatedServer.getServerIndex());

        if (firstTimeInQueue) {
            nextEvent = new WaitEvent(this.customer, updatedServer, this.eventTime,
                    false);
        } else {
            int serverIndex = shop.findNearestSelfCheckIndex(this.allocatedServer);
            Server nextServer = shop.getServer(serverIndex);
            double serverAvailableTime = nextServer.getAvailableTime();

            if (this.eventTime == serverAvailableTime) {
                nextEvent = new ServeEvent(this.customer, nextServer, serverAvailableTime);
            } else {
                nextEvent = new WaitEvent(this.customer, nextServer, serverAvailableTime,
                        false);
            }
        }


        return new Pair<Shop,Event>(shop,nextEvent);
    }

    // =======================================================================

    @Override
    public String toString() {
        if (firstTimeInQueue) {
            return String.format("%s waits at %s",
                    super.toString(),
                    this.allocatedServer.toString());
        }
        return "";
    }
}
