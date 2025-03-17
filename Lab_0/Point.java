class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "point " + "(" + String.format("%.3f", this.x) + "," + String.format("%.3f", this.y) + ")";
    }

    public Point midPoint(Point y) {
        double midX = (this.x + y.x)/2;
        double midY = (this.y + y.y)/2;

        return new Point(midX,midY);
    }

    public double angleTo(Point y) {
        double y1 = y.y - this.y;
        double x1 = y.x - this.x;
        return Math.atan2(y1,x1);
    }
    public Point moveTo (double angle, double dist) {
        double newX = this.x + dist * Math.cos(angle);
        double newY = this.y + dist * Math.sin(angle);
        return new Point(newX,newY);
    }
}

