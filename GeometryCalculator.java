public class GeometryCalculator {

    public static void main(String[] args) {
        ShapeCalculator calc = new ShapeCalculator();

System.out.println("Luas Lingkaran (r=7)  : "
        + calc.hitungLuas(new Lingkaran(7)));

System.out.println("Luas Persegi (s=5)    : "
        + calc.hitungLuas(new Persegi(5)));

System.out.println("Luas Segitiga (a=6,t=4): "
        + calc.hitungLuas(new Segitiga(6, 4)));
    }
}

class ShapeCalculator {

    public double hitungLuas(Shape shape) {
        return shape.hitungLuas();
    }
}

abstract class Shape {
    public abstract double hitungLuas();
}

class Lingkaran extends Shape {

    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }
}

class Persegi extends Shape {

    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }
}

class Segitiga extends Shape {

    private double alas, tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }
}