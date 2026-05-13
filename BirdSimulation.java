public class BirdSimulation {

    public static void main(String[] args) {
        Bird[] birds = {
            new Sparrow("Burung Gereja"),
            new Eagle("Elang"),
            new Penguin("Pinguin") 
        };

        System.out.println("=== Semua burung mencoba terbang ===");
        for (Bird bird : birds) {
            try {
                bird.terbang();
            } catch (UnsupportedOperationException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}

class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public void terbang() {
        System.out.println(name + " sedang terbang...");
    }

    public void makan() {
        System.out.println(name + " sedang makan.");
    }
}

class Sparrow extends Bird {
    public Sparrow(String name) { super(name); }

    @Override
    public void terbang() {
        System.out.println(name + " terbang dengan cepat ke sana kemari!");
    }
}

class Eagle extends Bird {
    public Eagle(String name) { super(name); }

    @Override
    public void terbang() {
        System.out.println(name + " melayang tinggi di angkasa!");
    }
}

class Penguin extends Bird {
    public Penguin(String name) { super(name); }

    @Override
    public void terbang() {
        throw new UnsupportedOperationException(name + " tidak bisa terbang!");
    }

    public void berenang() {
        System.out.println(name + " berenang dengan lincah di air!");
    }
}
