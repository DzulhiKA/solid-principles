import java.util.ArrayList;
import java.util.List;

public class BirdSimulation {

    public static void main(String[] args) {
        List<Bird> semuaBurung = new ArrayList<>();

        semuaBurung.add(new Sparrow("Burung Gereja"));
        semuaBurung.add(new Eagle("Elang"));
        semuaBurung.add(new Penguin("Pinguin"));

        System.out.println("=== Semua burung makan ===");
        for (Bird bird : semuaBurung) {
            bird.makan();
        }

        System.out.println("\n=== Hanya burung yang bisa terbang ===");
        for (Bird bird : semuaBurung) {
            if (bird instanceof FlyingBird) {
                ((FlyingBird) bird).terbang();
            } else {
                System.out.println(bird.getName() + " tidak bisa terbang.");
            }
        }
    }
}

interface FlyingBird {
    void terbang();
}

abstract class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makan() {
        System.out.println(name + " sedang makan.");
    }
}

class Sparrow extends Bird implements FlyingBird {

    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void terbang() {
        System.out.println(name + " terbang dengan cepat ke sana kemari!");
    }
}

class Eagle extends Bird implements FlyingBird {

    public Eagle(String name) {
        super(name);
    }

    @Override
    public void terbang() {
        System.out.println(name + " terbang tinggi di langit!");
    }
}

class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    public void berenang() {
        System.out.println(name + " berenang dengan lincah di air!");
    }
}