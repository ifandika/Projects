import java.util.Scanner;

// Child class Mahasiswa
public class P7MahasiswaTeori extends P7Mahasiswa {
  public Scanner scanner = new Scanner(System.in);
  public double nilaiUjian;
  public double nilaiTugas;

  @Override
  public void hitungNilaiAkhir() {
    // Nilai akhir = (nilai ujian x 0.65) + (nilai tugas x 0.35)
    nilaiAkhir = (nilaiUjian * 0.65) + (nilaiTugas * 0.35);
    System.out.println("\nNilai Akhir Mahasiswa Teori, Nama : "+nama+" adalah "+nilaiAkhir);
  }

  @Override
  public void inputData() {
    try {
      System.out.println("\n[INFO] Input data Mahasiswa Teori");
      System.out.print("NIM : ");
      NIM = scanner.nextInt();

      scanner.nextLine();
      System.out.print("Nama : ");
      nama = scanner.nextLine();
      
      System.out.print("Nilai Ujian : ");
      nilaiUjian = scanner.nextDouble();
      
      System.out.print("Nilai Tugas : ");
      nilaiTugas = scanner.nextDouble();

      System.out.println("\n[INFO] Hasil Input Data Mahasiswa");
      System.out.println("NIM \t:"+NIM);
      System.out.println("Nama \t:"+nama);
      System.out.println("Nilai Ujian :"+nilaiUjian);
      System.out.println("Nilai Tugas :"+nilaiTugas);
    }
    catch (Exception e) {
      scanner.close();
      System.err.println(e.getMessage());
    }
  }  
}
