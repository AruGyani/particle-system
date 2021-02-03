public class PVector {
    public double x, y, z;

    private boolean two_dimension = false, three_dimension = false;

    public PVector(double x, double y) {
        this.x = x;
        this.y = y;
        
        two_dimension = true;
        three_dimension = false;
    }

    public PVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        three_dimension = true;
        two_dimension = false;
    }

    public PVector() {
        // Burner for auto-init
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    // Set Methods
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(PVector v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    // Random 2D & 3D
    public void random2D() {
        this.x = (double) (Math.random() * 2 - 1);
        this.y = (double) (Math.random() * 2 - 1);
    }

    public void random3D() {
        this.x = (double) (Math.random() * 2  - 1);
        this.y = (double) (Math.random() * 2  - 1);
        this.z = (double) (Math.random() * 2  - 1);
    }

    // Copy
    public PVector copy() {        
        if (two_dimension && !three_dimension) return new PVector(x, y);
        else return new PVector(x, y, z);
    }

    public PVector get() {
        return copy();
    }

    // Print
    public void print() {
        if (two_dimension && !three_dimension) System.out.println("x: " + x + ", y: " + y);
        else if (three_dimension && !two_dimension) System.out.println("x: " + x + ", y: " + y + ", z: " + z);
    }

    // Add Vectors
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void add(PVector v) {
        this.x += v.x;
        this.y += v.y;
        this.z += v.z;
    }

    public void add(double scalar) {
        if (two_dimension && !three_dimension) {
            this.x += scalar;
            this.y += scalar;
        } else {
            this.x += scalar;
            this.y += scalar;
            this.z += scalar;
        }
    }

    // Divide Vectors
    public void div(double x, double y) {
        this.x /= x;
        this.y /= y;
    }

    public void div(double x, double y, double z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
    }

    public void div(PVector v) {
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
    }

    public void div(double scalar) {
        this.x /= scalar;
        this.y /= scalar;
        this.z /= scalar;
    }

     // Multiply Vectors
     public void mult(double x, double y) {
        this.x *= x;
        this.y *= y;
    }

    public void mult(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
    }

    public void mult(PVector v) {
        this.x *= v.x;
        this.y *= v.y;
        this.z *= v.z;
    }

    public void mult(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    public static PVector sub(PVector v1, PVector v2) {
        return new PVector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public double mag() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public static double constrain(double value, double min, double max) {
        return (value < min) ? min : ((value < max) ? value : max);
    }

    public static double constrain(double value, int min, int max) {
        return (value < min) ? min : ((value < max) ? value : max);
    }

    public void normalize() {
        double magnitude = mag();

        div(magnitude);
    }
}
