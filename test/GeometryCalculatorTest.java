import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GeometryCalculatorTest {

    ShapeCalculator calc = new ShapeCalculator();

    @Test
    void testLuasLingkaran() {
        double hasil = calc.hitungLuas(new Lingkaran(7));

        assertEquals(153.93804002589985, hasil, 0.001);
    }

    @Test
    void testLuasPersegi() {
        double hasil = calc.hitungLuas(new Persegi(5));

        assertEquals(25, hasil);
    }

    @Test
    void testLuasSegitiga() {
        double hasil = calc.hitungLuas(new Segitiga(6, 4));

        assertEquals(12, hasil);
    }
}