public class StudentManager {

    public static void main(String[] args) {
        Student student = new Student("Budi Santoso", 85, 90, 78);
 
        NilaiCalculator calculator = new NilaiCalculator();
        double nilaiAkhir = calculator.hitungNilaiAkhir(student);
 
        ReportPrinter printer = new ReportPrinter();
        printer.printReport(student, nilaiAkhir);
 
        StudentRepository repository = new StudentRepository();
        repository.save(student);
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

    public String getName() {
        return name;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    public double getNilaiUAS() {
        return nilaiUAS;
    }
}

class NilaiCalculator {
    public double hitungNilaiAkhir(Student student) {
        return (student.getNilaiTugas() * 0.30)
                + (student.getNilaiUTS() * 0.35)
                + (student.getNilaiUAS() * 0.35);
    }
}

class ReportPrinter {
    public void printReport(Student student, double nilaiAkhir) {
        System.out.println("======= LAPORAN MAHASISWA =======");
        System.out.println("Nama       : " + student.getName());
        System.out.println("Tugas      : " + student.getNilaiTugas());
        System.out.println("UTS        : " + student.getNilaiUTS());
        System.out.println("UAS        : " + student.getNilaiUAS());
        System.out.println("Nilai Akhir: " + nilaiAkhir);
        System.out.println("=================================");
    }
}

class StudentRepository {
    public void save(Student student) {
        String data = student.getName() + ","
                + student.getNilaiTugas() + ","
                + student.getNilaiUTS() + ","
                + student.getNilaiUAS();
        System.out.println("[DATABASE] Menyimpan data: " + data);
    }
}
