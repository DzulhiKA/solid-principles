import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentManagerTest {

    private Student student;
    private NilaiCalculator calculator;

    @Mock
    private StudentRepository mockRepository;

    @Spy
    private NilaiCalculator spyCalculator;

    @BeforeEach
    void setUp() {
        student = new Student("Budi Santoso", 85, 90, 78);
        calculator = new NilaiCalculator();
    }

    // ===== Student Tests =====

    @Test
    void testStudentGetName() {
        assertEquals("Budi Santoso", student.getName());
    }

    @Test
    void testStudentGetNilaiTugas() {
        assertEquals(85, student.getNilaiTugas());
    }

    @Test
    void testStudentGetNilaiUTS() {
        assertEquals(90, student.getNilaiUTS());
    }

    @Test
    void testStudentGetNilaiUAS() {
        assertEquals(78, student.getNilaiUAS());
    }

    // ===== NilaiCalculator Tests =====

    @Test
    void testHitungNilaiAkhirCorrect() {
        double expected = (85 * 0.30) + (90 * 0.35) + (78 * 0.35);
        double actual = calculator.hitungNilaiAkhir(student);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void testHitungNilaiAkhirNilaiMaksimum() {
        Student studentPerfect = new Student("Perfect", 100, 100, 100);
        double result = calculator.hitungNilaiAkhir(studentPerfect);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void testHitungNilaiAkhirNilaiMinimum() {
        Student studentZero = new Student("Zero", 0, 0, 0);
        double result = calculator.hitungNilaiAkhir(studentZero);
        assertEquals(0.0, result, 0.01);
    }

    // ===== ReportPrinter Tests =====

    @Test
    void testPrintReportContainsName() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ReportPrinter printer = new ReportPrinter();
        printer.printReport(student, 84.3);

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(output.contains("Budi Santoso"));
        assertTrue(output.contains("LAPORAN MAHASISWA"));
    }

    @Test
    void testPrintReportContainsNilaiAkhir() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ReportPrinter printer = new ReportPrinter();
        printer.printReport(student, 84.3);

        System.setOut(System.out);
        assertTrue(outContent.toString().contains("84.3"));
    }

    // ===== TEST DOUBLE: MOCK =====

    @Test
    void testMockRepositorySaveCalledOnce() {
        mockRepository.save(student);
        verify(mockRepository, times(1)).save(student);
    }

    @Test
    void testMockRepositoryNeverCalledWithoutInvocation() {
        verify(mockRepository, never()).save(any(Student.class));
    }

    @Test
    void testMockRepositorySaveWithCorrectStudent() {
        mockRepository.save(student);
        verify(mockRepository).save(student);
    }

    // ===== TEST DOUBLE: SPY =====

    @Test
    void testSpyCalculatorVerifyAndReturnRealValue() {
        double result = spyCalculator.hitungNilaiAkhir(student);
        verify(spyCalculator, times(1)).hitungNilaiAkhir(student);
        assertEquals((85 * 0.30) + (90 * 0.35) + (78 * 0.35), result, 0.01);
    }

    // ===== TEST DOUBLE: STUB =====

    @Test
    void testStubStudentNilaiTetap() {
        Student stubStudent = new Student("Stub Student", 70, 80, 75);
        NilaiCalculator calc = new NilaiCalculator();
        double result = calc.hitungNilaiAkhir(stubStudent);
        // (70*0.30) + (80*0.35) + (75*0.35) = 21 + 28 + 26.25 = 75.25
        assertEquals(75.25, result, 0.01);
    }
}