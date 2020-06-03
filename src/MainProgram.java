import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainProgram extends JFrame implements MouseListener, MouseMotionListener, MouseWheelListener {

    int clickx, clicky;
    int pressx, pressy;
    int releasex, releasey;
    int enterx, entery;
    int exitx, exity;
    int dragx, dragy;
    int movex, movey;
    int mousebutton;

    public static void main(String[] args) {
        MainProgram MP = new MainProgram();
    }

    MainProgram() {
        setTitle("Test Mouse");
        addMouseListener(this); // listener tombol mouse
        addMouseMotionListener(this); // listener pergerakan mouse
        addMouseWheelListener(this);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, 300, 200);
        g.setColor(Color.BLACK);
        g.drawString("Mouse clicked : " + mousebutton + " at " + clickx + "," + clicky, 10, 50);
        g.drawString("Mouse Entered : " + enterx + "," + entery, 10, 75);
        g.drawString("Mouse Exit : " + exitx + "," + exity, 10, 100);
        g.drawString("Mouse Pressed : " + mousebutton + " at " + pressx + "," + pressy, 10, 125);
        g.drawString("Mouse Released : " + mousebutton + " at " + releasex + ", " + releasey, 10, 150);
        g.drawString("Mouse Dragged : " + dragx + "," + dragy, 10, 175);
        g.drawString("Mouse Moved : " + movex + "," + movey, 10, 200);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Menyimpan posisi mouse
        clickx = e.getX();
        clicky = e.getY();
        // Mengupdate Tombol
        checkButton(e);
        // refresh tampilan
        repaint();
    }

    public void checkButton(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                mousebutton = 1;
                break;
            case MouseEvent.BUTTON2:
                mousebutton = 2;
                break;
            case MouseEvent.BUTTON3:
                mousebutton = 3;
                break;
            default:
                mousebutton = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressx = e.getX();
        pressy = e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        releasex = e.getX();
        releasey = e.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        enterx = e.getX();
        entery = e.getY();
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        exitx = e.getX();
        exity = e.getY();
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dragx = e.getX();
        dragy = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        movex = e.getX();
        movey = e.getY();
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("Saya");
    }
}
