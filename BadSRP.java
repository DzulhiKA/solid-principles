public class BadSRP {

    public static void main(String[] args) {
        Student student = new Student("Budi Santoso", 85, 90, 78);
        student.printReport();
        student.saveToDatabase();
    }
}

class Student {
    private String name;
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;

    public Student(String name, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.name = name;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
    }

    public String getName() { return name; }
    public double getNilaiTugas() { return nilaiTugas; }
    public double getNilaiUTS() { return nilaiUTS; }
    public double getNilaiUAS() { return nilaiUAS; }

    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.30) + (nilaiUTS * 0.35) + (nilaiUAS * 0.35);
    }
    public void printReport() {
        System.out.println("======= LAPORAN MAHASISWA =======");
        System.out.println("Nama     : " + name);
        System.out.println("Tugas    : " + nilaiTugas);
        System.out.println("UTS      : " + nilaiUTS);
        System.out.println("UAS      : " + nilaiUAS);
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
        System.out.println("=================================");
    }

    public void saveToDatabase() {
        // Simulasi penyimpanan ke database
        String data = name + "," + nilaiTugas + "," + nilaiUTS + "," + nilaiUAS;
        System.out.println("[DATABASE] Menyimpan data: " + data);
    }
}
