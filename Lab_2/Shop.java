class Shop {
    private final ImList<Server> servers;

    public Shop(ImList<Server> servers) {
        this.servers = servers;
    }

    // ========================== HELPERS  ================================

    public static ImList<Server> initialize(int numOfServers) {
        ImList<Server> tempServers = new ImList<>();

        for (int i = 0; i < numOfServers; i++) {
            tempServers = tempServers.add(new Server(0.0));
        }
        return tempServers;
    }

    // find first available server
    public int findAvailableServerIndex(double time) {
        ImList<Server> currServers = this.getServers();

        for (int i = 0; i < currServers.size(); i++) {
            if (currServers.get(i).startTime() <= time) {
                return i;
            }
        }
        return -1;
    }

    public ImList<Server> getServers() {
        return this.servers;
    }


    // ====================================================================

    public String toString() {
        return this.servers.toString();
    }
}
