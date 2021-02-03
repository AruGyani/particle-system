import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1L;

    public final static int WIDTH = 640;
    public final static int HEIGHT = 360;
    
    private static final int UPS = 60, FPS = 60;

    private static final boolean RENDER_TIME = true;
    private static final boolean running = true;

    private ParticleSystem particles;
    private ArrayList<Repeller> repellers = new ArrayList<Repeller>();

    public Main() {
        addMouseListener(this);

        setFocusable(true);
    }

    public void setup() {
        particles = new ParticleSystem(new PVector(WIDTH / 2, 50));
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        particles.addParticle();
        PVector gravity = new PVector(0, 0.1);
        particles.applyForce(gravity);

        for (Repeller r : repellers) {
            particles.applyRepeller(r);
        }
        

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        for (Repeller r : repellers) {
            r.render(g2);
        }

        particles.run(g2);
    }

    public void run() {
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                repaint();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (RENDER_TIME) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Main main = new Main();

        main.setDoubleBuffered(true);
        frame.add(main);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        main.setup();
        main.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            repellers.add(new Repeller(new PVector(e.getX(), e.getY()), 200));
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            repellers.clear();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }        
}
