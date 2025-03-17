class Circle {
    Point centre;
    double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }
    public String toString() {
        return "circle of radius " + String.format("%.2f",this.radius) + 
        " centred at  " + this.centre.toString();
    }
}

