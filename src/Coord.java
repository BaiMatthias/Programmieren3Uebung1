
public class Coord {


    private double x;
    private double y;

    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    public Coord() {
        x = 0.0;
        y = 0.0;
    }

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coord(Coord p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getDistance(Coord that) {
        double dx, dy;
        dx = this.x - that.getX();
        dy = this.y - that.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
