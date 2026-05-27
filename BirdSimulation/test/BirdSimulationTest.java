public class BirdSimulationTest {

    public static void main(String[] args) {
        testSparrowIsFlyingBird();
        testEagleIsFlyingBird();
        testPenguinIsNotFlyingBird();
        testPenguinCanSwim();
        testFlyingBirdCanFlyWithoutError();

        System.out.println("Semua unit test BirdSimulation berhasil dijalankan.");
    }

    static void testSparrowIsFlyingBird() {
        Sparrow sparrow = new Sparrow("Burung Gereja");

        assertTrue(sparrow instanceof FlyingBird, "Sparrow harus termasuk FlyingBird");
        assertEquals("Burung Gereja", sparrow.getName(), "Nama Sparrow harus sesuai");
    }

    static void testEagleIsFlyingBird() {
        Eagle eagle = new Eagle("Elang");

        assertTrue(eagle instanceof FlyingBird, "Eagle harus termasuk FlyingBird");
        assertEquals("Elang", eagle.getName(), "Nama Eagle harus sesuai");
    }

    static void testPenguinIsNotFlyingBird() {
        Penguin penguin = new Penguin("Pinguin");

        assertFalse(penguin instanceof FlyingBird, "Penguin tidak boleh termasuk FlyingBird");
        assertEquals("Pinguin", penguin.getName(), "Nama Penguin harus sesuai");
    }

    static void testPenguinCanSwim() {
        Penguin penguin = new Penguin("Pinguin");

        try {
            penguin.berenang();
            System.out.println("testPenguinCanSwim berhasil");
        } catch (Exception e) {
            throw new AssertionError("Penguin seharusnya dapat berenang tanpa error");
        }
    }

    static void testFlyingBirdCanFlyWithoutError() {
        FlyingBird sparrow = new Sparrow("Burung Gereja");
        FlyingBird eagle = new Eagle("Elang");

        try {
            sparrow.terbang();
            eagle.terbang();
            System.out.println("testFlyingBirdCanFlyWithoutError berhasil");
        } catch (Exception e) {
            throw new AssertionError("FlyingBird seharusnya dapat terbang tanpa error");
        }
    }

    static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
        System.out.println(message + " - OK");
    }

    static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
        System.out.println(message + " - OK");
    }

    static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ". Expected: " + expected + ", Actual: " + actual);
        }
        System.out.println(message + " - OK");
    }
}