double epsilon = 1E-15;

double distanceBetween(Point p, Point q) {
    double dx = p.x - q.x;
    double dy = p.y = q.y;

    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
}

boolean circleContainsPoint(Circle c, Point p) {
    return distanceBetween(c.centre, p) < c.radius + epsilon;
}

Circle createUnitCircle(Point p, Point q) {
    Point m = p.midPoint(q);
    double angle = p.angleTo(q);

    double mp = distanceBetween(p,m);
    double d = Math.sqrt(1 - Math.pow(mp,2));

    return new Circle(midPoint.moveTo((angle+Math.PI)/2,d),1.0);
}


int findMaxDiscCoverage(ImList<Point> points) {
    int maxDiscCoverage = 0;
    int numOfPoints = points.size();

    for (int i = 0; i < numOfPoints - 1; i++) {
        for (int j = i + 1; j < numOfPoints; j++) {
            Point p = points.get(i);
            Point q = points.get(j);
            double distPQ = distanceBetween(p, q);
            if (distPQ < 2.0 + epsilon && distPQ > 0) {
                Point midpoint = new Point((p.x + q.x) / 2, (p.y + q.y) / 2);
                double cp = Math.sqrt(1.0 - Math.pow(distanceBetween(midpoint, p), 2));
                double theta = Math.atan2(p.x - q.x, p.y - q.y);
                Circle c = new Circle(
                        new Point(p.x + cp * Math.cos(theta + Math.PI / 2),
                            p.y + cp * Math.sin(theta + Math.PI / 2)), 
                        1.0);

                int coverage = 0;
                for (Point point : points) {
                    if (circleContainsPoint(c, point)) {
                        coverage = coverage + 1;
                    }
                }
                if (coverage > maxDiscCoverage) {
                    maxDiscCoverage = coverage;
                }
            }
        }
    }
    return maxDiscCoverage;
}
