import java.awt.Graphics2D;
import java.awt.Color;

public class Repeller {
    public PVector location;
    public float r = 10;
    public float strength = 100;

    public Repeller(PVector l) {
        location = l.copy();
    }

    
    public Repeller(PVector l, float strength) {
        location = l.copy();

        this.strength = strength;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillOval((int) location.x, (int) location.y, (int)r * 2, (int) r * 2);
    }

    public PVector repel(Particle p) {
        PVector direction = PVector.sub(location, p.location);

        double d = direction.mag();
        d = PVector.constrain(d, 5, 100);

        direction.normalize();

        double force = -1 * strength / (d * d);
        direction.mult(force);

        return direction;
    }
}
