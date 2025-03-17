class Simulator {
    private final Integer numOfServers;
    private final ImList<Double> arrivalTimes;
    private final ImList<Double> serviceTimes;

    Simulator(Integer numOfServers, ImList<Double> arrivalTimes, ImList<Double> serviceTimes) {
        this.numOfServers = numOfServers;
        this.arrivalTimes = arrivalTimes;
        this.serviceTimes = serviceTimes;
    }



    public String simulate() {
        Statistics stats = new Statistics(0,0);

        String output = "";

        // =================== Constructors =======================================

        // Creating the shop
        Shop shop = new Shop(Shop.initialize(numOfServers));

        // PQ for events
        PQ<Event> eventQueue = new PQ<Event>(new EventComp());

        // running through the arrival times and adding each customer as an arrive event
        for (int i = 0; i < this.arrivalTimes.size(); i++) {

            // creating the customer - (arrivalTime, serviceTime, id)
            Customer currCustomer = new Customer(this.arrivalTimes.get(i), 
                    this.serviceTimes.get(i), i + 1);

            // adding the customer as an arrive event into the eventQueue

            eventQueue = eventQueue.add(new ArriveEvent(currCustomer));
        }
        // =======================================================================



        // ====================== Algorithm ====================================

        while (!eventQueue.isEmpty()) {

            Event currEvent = eventQueue.poll().first();
            eventQueue = eventQueue.poll().second();

            /* curr event will be processed
               if it is arrive (two outcomes - serve or leave)
               if it is serve (one outcome - done)
               if it is done or leave (remove from queue)

               processing of logic is done within event classes
             */ 
            output = output + currEvent.toString() + "\n";

            stats = currEvent.updateStatistics(stats);
            Pair<Shop, PQ<Event>> processed = currEvent.process(shop, eventQueue);        
            shop = processed.first();
            eventQueue = processed.second();


        }
        int numServed = stats.getNumServed();
        int numLeft = stats.getNumLeft();

        output = output + String.format("[%d %d]", numServed, numLeft);
        return output;
    }

}
