import java.awt.Color;
import java.awt.Graphics;

public class Circle extends GraphicObject {

    public Circle() {
        super();
    }

    public Circle(Coord p, int size) {
        super(p, size);
    }

    public void draw(Graphics g) {
        g.drawOval((int) this.coordinate.getX() - size / 2, (int) coordinate.getY() - size / 2,
                size, size);
        g.setColor(Color.BLACK);
        g.drawString("#" + exemplarID + "of" + cnt,
                (int) coordinate.getX() - 15, (int) coordinate.getY());
    }
}
