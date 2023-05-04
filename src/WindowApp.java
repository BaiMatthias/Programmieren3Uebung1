import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WindowApp extends JFrame {

    private Timer timer;
    private ActionListener al;
    private Coord coordClicked;
    Dot dot1 = new Dot();
    private Circle c1 = new Circle(new Coord(125, 125), 100);
    private Dot d2 = new Dot(new Coord(325, 325), 100);
    private Dot[] d;
    private Circle[] c;


    private class MyWindowsListener extends WindowAdapter {
        public void windowClosing(WindowEvent ev) {
            System.exit(0);
        }
    }

    private class MyMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent ev) {
        }

        public void mousePressed(MouseEvent ev) {
            coordClicked.setX(ev.getX());
            coordClicked.setY(ev.getY());
            repaint();
        }

        public void mouseReleased(MouseEvent ev) {
        }

        public void mouseExited(MouseEvent ev) {
        }

        public void mouseEntered(MouseEvent ev) {
        }
    }

    public WindowApp(String s) {
        super(s);
        addWindowListener(new MyWindowsListener());
        addMouseListener(new MyMouseListener());
        addMouseListener(new MyMouseListener());
        setSize(400, 400);
        setVisible(true);
        GraphicObject.maxCoordinate.setX(400);
        GraphicObject.maxCoordinate.setY(400);

        coordClicked = new Coord();
        d = new Dot[5];
        c = new Circle[5];
        for (int i = 0; i < d.length; i++) {
            d[i] = new Dot();
        }
        for(int i = 0; i < c.length; i++){
        	c[i] = new Circle();
        }
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d2.coordMove(5, 2);
                GraphicObject.maxCoordinate.setX(getWidth());
                GraphicObject.maxCoordinate.setY(getHeight());
                for (int i = 0; i < d.length; i++) {
                    d[i].doStep();
                }
                for(int i = 0; i < c.length; i++){
                	c[i].doStep();
                }
                repaint();
            }
        };
        timer = new Timer(200, al);
        timer.start();
    }

    public void paint(Graphics g) {
        //clear window
        super.paint(g);
        //object state determination
        c1.bu(coordClicked);
        d2.bu(coordClicked);
        dot1.coordReplace(coordClicked);
        //show objects
        g.setColor(Color.CYAN);
       // c1.draw(g);
        g.setColor(Color.RED);
        //d2.draw(g);
        g.setColor(Color.GREEN);
        dot1.draw(g);
        //show a string
        g.setColor(Color.BLUE);
        g.drawString("MouseClick at: " + coordClicked.getX() + ", "
                + coordClicked.getY(), (int) coordClicked.getX() + 5, (int) coordClicked.getY() + 5);
        for (int i = 0; i < d.length; i++) {
        	d[i].bu(coordClicked);
            d[i].draw(g);
        }
        for (int i = 0; i < c.length; i++){
        	c[i].bu(coordClicked);
        	c[i].draw(g);
        }
    }
}
