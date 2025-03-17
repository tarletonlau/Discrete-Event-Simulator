class Statistics {
    private final int numLeft;
    private final int numServed;

    public Statistics(int numLeft, int numServed) {
        this.numLeft = numLeft;
        this.numServed = numServed;
    }

    public Statistics incrementLeft() {
        return new Statistics(this.numLeft + 1, this.numServed);
    }

    public Statistics incrementServed() {
        return new Statistics(this.numLeft, this.numServed + 1);
    }

    public int getNumLeft() {
        return this.numLeft;
    }

    public int getNumServed() {
        return this.numServed;
    }
}
