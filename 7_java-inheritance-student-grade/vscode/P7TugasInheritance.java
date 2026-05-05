/**
 * Tugas inheritance penilaian mahasiswa teori dan praktikum
 */
public class P7TugasInheritance {
  public static void main(String[] args) {
    P7MahasiswaTeori mahasiswaTeori = new P7MahasiswaTeori();
    mahasiswaTeori.inputData();
    mahasiswaTeori.hitungNilaiAkhir();

    P7MahasiswaPraktikum mahasiswaPraktikum = new P7MahasiswaPraktikum();
    mahasiswaPraktikum.inputData();
    mahasiswaPraktikum.hitungNilaiAkhir();
  }
}
