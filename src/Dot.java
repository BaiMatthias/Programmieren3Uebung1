import java.awt.Color;
import java.awt.Graphics;

public class Dot extends GraphicObject {

    public Dot() {
        super();
    }

    public Dot(Coord p, int size) {
        super(p, size);
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval((int) this.coordinate.getX() - size / 2, (int) coordinate.getY() - size / 2,
                size, size);
        g.setColor(Color.BLACK);
        g.drawString("#" + exemplarID + "of" + cnt,
                (int) coordinate.getX() - 15, (int) coordinate.getY());
    }
}


