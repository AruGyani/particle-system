import java.awt.Color;
import java.awt.Graphics2D;

public class Confetti extends Particle {
    private Color[] colors = {new Color(168, 100, 253), new Color(41, 205, 255), new Color(120, 255, 68), new Color(255, 113, 141), new Color(253, 255, 106)};
    private Color randomColor = colors[(int) (Math.random() * colors.length)];

    //private double angle;

    public Confetti(PVector l) {
        super(l);

        //angle = map(location.x, 0, Main.WIDTH, 0, Math.PI * 2);
    }

    public void render(Graphics2D g) {
        g.setColor(randomColor);
        
        g.fillRect((int) location.x, (int) location.y, size, size * 2);
    }

    public double map(double value, double istart, double istop, double ostart, double ostop) {
        return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
    }
}
