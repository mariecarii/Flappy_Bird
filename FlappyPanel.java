import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlappyPanel extends JPanel implements KeyListener, ActionListener {

    final int WIDTH = 525;
    final int HEIGHT = 550;
    int flappyHeight = HEIGHT / 4;
    int flappyVelocity = 0;
    int flappyAcceleration = 8;
    int flappyImpulse = 1;


    public FlappyPanel() {

        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        addKeyListener(this);

        setBackground(Color.black);
        new Timer(40, this).start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFlappy(g);
    }
    private void drawFlappy(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(75, flappyHeight + flappyVelocity, 25, 25);
    }
    public void actionPerformed(ActionEvent e) {
        flappyAcceleration += flappyImpulse;
        flappyVelocity += flappyAcceleration;
        repaint();
    }

    public void keyTyped (KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == e.VK_SPACE) {
            flappyAcceleration = -8;
        }
    }
    public void keyReleased(KeyEvent e) {

    }
}
