import java.awt.Color;
import java.awt.Graphics2D;

public class Particle {
    public PVector location;
    public PVector velocity;
    public PVector acceleration;

    public int size = 8;
    public int lifespan;

    public double mass = 1;

    public Particle(PVector l) {
        location = l.copy();
        // acceleration = new PVector();
        // velocity = new PVector();

        acceleration = new PVector(0, 0.1);
        velocity = new PVector((double) (Math.random() * 2 - 1), (double) (Math.random() * 2 - 2));

        lifespan = 255;
    }

    public Particle() {
        location = new PVector();
        // acceleration = new PVector();
        // velocity = new PVector();

        acceleration = new PVector(0, 0.1);
        velocity = new PVector((double) (Math.random() * 2 - 1), (double) (Math.random() * 2 - 2));

        lifespan = 255;
    }

    public void update() {
        velocity.add(acceleration);
        location.add(velocity);

        acceleration.mult(0);

        lifespan -= 2;

        if (lifespan < 0) lifespan = 0;
    }

    public void render(Graphics2D g) {
        g.setColor(new Color(0, 0, 0, lifespan));
        g.fillOval((int) location.x, (int) location.y, size, size);
    }

    public void applyForce(PVector force) {
        PVector f = force.copy();

        f.div(mass);
        acceleration.add(f);
    }

    public boolean isDead() {
        if (lifespan <= 0) return true;
        else return false;
    }
}
