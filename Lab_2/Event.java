interface Event {

    public double eventTime();

    public Pair<Shop,PQ<Event>> process(Shop shop, PQ<Event> eventQueue);
    
    public Customer getCustomer();
    
    public Statistics updateStatistics(Statistics stats);
}

