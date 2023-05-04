import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

abstract class GraphicObject {


    static int cnt = 0;
    static Coord maxCoordinate = new Coord(1.0, 1.0);
    int exemplarID = 0;
    Coord coordinate;
    protected Coord step = new Coord();

    protected int size = 15;
    protected Color c = Color.BLUE;
    private Random rnd = new Random();

    public GraphicObject() {
        coordinate = new Coord(rnd.nextInt((int) maxCoordinate.getX()),
                rnd.nextInt((int) maxCoordinate.getY()));
        size = 15;
        cnt++;
        exemplarID = cnt;
        step.setX(rnd.nextInt(60) / 10 - 3.0);
        step.setY(rnd.nextInt(60) / 10 - 3.0);
        int r1 = rnd.nextInt(255);
        int g1 = rnd.nextInt(255);
        int b1 = rnd.nextInt(255);
        c = new Color(r1, g1, b1);
        size = 30;
    }

    public GraphicObject(Coord p, int size) {
        this();
        coordinate.setX(p.getX());
        coordinate.setY(p.getY());
        this.size = size;
    }

    public void doStep() {
        coordMove((int) step.getX(), (int) step.getY());
        coordCheck();
    }

    public void coordCheck() {
        //Der Objekt muss am Arbeitsfenster bleiben!
        if ((this.coordinate.getX() + this.getSize()) >= this.maxCoordinate.getX() || (this.coordinate.getX() - this.getSize()) <= 0) {
            // Abprallen

            if ((this.coordinate.getX() + this.getSize()) > this.maxCoordinate.getX()) {
                this.coordinate.setX(this.maxCoordinate.getX() - this.getSize());
            } else if ((this.coordinate.getX() - this.getSize()) < 0) {
                this.coordinate.setX(this.getSize());
            }

            while(this.step.getX() <= 0.0) {
                this.step.setX(rnd.nextInt(60) / 10 - 3.0);
            }
            this.step.setX(-this.step.getX());
        }
        if ((this.coordinate.getY() + this.getSize()) >= this.maxCoordinate.getY() || (this.coordinate.getY() - this.getSize()) <= 0) {
            // Abprallen

            if ((this.coordinate.getY() + this.getSize()) > this.maxCoordinate.getY()) {
                this.coordinate.setY(this.maxCoordinate.getY() - this.getSize());
            } else if ((this.coordinate.getY() - this.getSize()) < 0) {
                this.coordinate.setY(this.getSize());
            }

            while(this.step.getY() <= 0.0) {
                this.step.setY(rnd.nextInt(60) / 10 - 3.0);
            }

            this.step.setY(-this.step.getY());
        }

    }

    public void coordReplace(Coord p) {
        coordinate.setX(p.getX());
        coordinate.setY(p.getY());
    }

    public void coordMove(int x, int y) {
        coordinate.setX(coordinate.getX() + x);
        coordinate.setY(coordinate.getY() + y);
    }

    public double getX() {
        return coordinate.getX();
    }

    public double getY() {
        return coordinate.getY();
    }

    public Coord coordGet() {
        return coordinate;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * - bu Methode � wir sind �ngstlich, aber brav! :-D ----------
     */
    protected void bu(Coord p) {
        double distance = p.getDistance(this.coordinate);
        if (distance > 3 * this.size) {
            size *= 2;
        } else if (distance < this.size / 2) {
            size /= 2;
        }
    }

    public abstract void draw(Graphics g);
}
