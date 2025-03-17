class Simulator {
    private final Integer numOfServers;
    private final ImList<Double> arrivalTimes;
    private final ImList<Double> serviceTimes;

    Simulator(Integer numOfServers,ImList<Double> arrivalTimes,ImList<Double> serviceTimes) {
        this.numOfServers = numOfServers;
        this.arrivalTimes = arrivalTimes;
        this.serviceTimes = serviceTimes;
    }

    public String simulate() {
        String output = "";

        int numServed = 0;
        int numLeft = 0;

        ImList<Server> serverAvailableTimes = new ImList<Server>();
        
        for (int i = 1; i <= this.numOfServers; i++) {
            serverAvailableTimes = serverAvailableTimes.add(new Server(0.0));
        }

        ImList<Customer> customerQueue = new ImList<Customer>();

        for (int i = 0; i < this.arrivalTimes.size(); i++) {
            customerQueue = customerQueue.add(new Customer(this.arrivalTimes.get(i),
            this.serviceTimes.get(i)));
        }



        int customerId = 1;

        for (Customer currCustomer : customerQueue) {
            double time = currCustomer.startTime();
            output = output + String.format("%.3f customer %s arrives", time, customerId) + "\n";

            int index = 0;

            while (index < serverAvailableTimes.size() &&
                serverAvailableTimes.get(index).startTime() > time) {
                index = index + 1;
            }

            if (index < serverAvailableTimes.size()) {
                serverAvailableTimes = serverAvailableTimes.set(index,
                serverAvailableTimes.get(index).use(currCustomer));
                numServed = numServed + 1;

                output = output + String.format("%.3f customer %s served by server %s", 
                    time, customerId, (index + 1)) + "\n";

            } else {
                numLeft = numLeft + 1;
                
                output = output + String.format("%.3f customer %s leaves", time, customerId) + "\n";
            
            }

            customerId = customerId + 1;
        }

        output = output + "[" + numServed + " " + numLeft + "]";
        return output;
    }

    public String toString() {
        return numOfServers + "," + arrivalTimes + "," + serviceTimes;
    }

}
