import javax.swing.*;
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

    int[] wallX = {WIDTH, WIDTH + WIDTH / 2};
    int[] gap = {(int) (Math.random() * (HEIGHT - 150)), (int) (Math.random() * (HEIGHT - 100))};
    final int wallXVelocity = 5;
    final int wallWidth = 50;

    boolean gameOver = false;

    public FlappyPanel() {

        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        addKeyListener(this);

        setBackground(Color.black);
        new Timer(40, this).start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!gameOver) {
            drawWall(g);
            logic();
            drawFlappy(g);
        } else {


        }




    }
    private void drawFlappy(Graphics g) {

        g.setColor(Color.white);

        g.fillRect(75, flappyHeight + flappyVelocity, 25, 25);
    }
    private void drawWall(Graphics g) {
        for (int i=0; i<2; i++) {
            g.setColor(Color.red);
            g.fillRect(wallX[i], 0, wallWidth, HEIGHT);

            g.setColor(Color.BLACK);
            g.fillRect(wallX[i], gap[i], wallWidth, 100);
        }
    }
    private void logic() {
        for (int i=0; i<2; i++) {
            if (wallX[i] <= 100 && wallX[i] + wallWidth >= 100 || wallX[i] <= 75 && wallX[i] + wallWidth >=75) {
                if ((flappyHeight + flappyVelocity) >= 0 && (flappyHeight + flappyVelocity) <= gap[i] || (flappyHeight + flappyVelocity + 25) >= gap[i] + 100 && (flappyHeight + flappyVelocity + 25) <= HEIGHT) {
                    gameOver = true;
                }
            }

            if (wallX[i] + wallWidth <= 0) {
                wallX[i] = WIDTH;
                gap[i] = (int) (Math.random() * (HEIGHT - 150));
            }

        }

    }

    public void actionPerformed(ActionEvent e) {
        flappyAcceleration += flappyImpulse;
        flappyVelocity += flappyAcceleration;

        wallX[0] -= wallXVelocity;
        wallX[1] -= wallXVelocity;

        repaint();
    }

    public void keyTyped (KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == e.VK_SPACE) {
            flappyAcceleration = -10;
        }
    }
    public void keyReleased(KeyEvent e) {

    }
}
