public class BadOCP {

    public static void main(String[] args) {
        ShapeCalculator calc = new ShapeCalculator();

        System.out.println("Luas Lingkaran (r=7)  : " + calc.hitungLuas("lingkaran", 7, 0));
        System.out.println("Luas Persegi (s=5)    : " + calc.hitungLuas("persegi", 5, 0));
        System.out.println("Luas Segitiga (a=6,t=4): " + calc.hitungLuas("segitiga", 6, 4));
    }
}

class ShapeCalculator {

    // ❌ Setiap tambah bentuk baru = harus ubah method ini (melanggar OCP)
    public double hitungLuas(String bentuk, double a, double b) {
        if (bentuk.equals("lingkaran")) {
            return Math.PI * a * a; // a = jari-jari

        } else if (bentuk.equals("persegi")) {
            return a * a; // a = sisi

        } else if (bentuk.equals("segitiga")) {
            return 0.5 * a * b; // a = alas, b = tinggi

        } else {
            throw new IllegalArgumentException("Bentuk tidak dikenali: " + bentuk);
        }
    }
}