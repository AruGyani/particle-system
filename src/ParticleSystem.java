import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

public class ParticleSystem {
    public ArrayList<Particle> particles;
    public PVector origin;

    public ParticleSystem(PVector location) {
        origin = location.get();
        particles = new ArrayList<Particle>();
    }

    public void addParticle() {
        particles.add(new Particle(origin));
    }

    public void addConfetti() {
        particles.add(new Confetti(origin));
    }

    public void applyForce(PVector f) {
        for (Particle p : particles) {
            p.applyForce(f);
        }
    }

    public void applyRepeller(Repeller r) {
        for (Particle p : particles) {
            PVector force = r.repel(p);
            p.applyForce(force);
        }
    }

    public void run(Graphics2D g) {
        Iterator<Particle> it = particles.iterator();
        
        while (it.hasNext()) {
            Particle p = it.next();

            p.render(g);
            p.update();

            if (p.isDead()) it.remove();
        }
    }
}
