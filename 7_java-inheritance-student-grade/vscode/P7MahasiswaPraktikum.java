import java.util.Scanner;

// Child class Mahasiswa
public class P7MahasiswaPraktikum extends P7Mahasiswa {
  public Scanner scanner = new Scanner(System.in);
  public double nilaiPraktikum;
  public double nilaiLaporan;
  
  @Override
  public void hitungNilaiAkhir() {
    // Nilai akhir = (nilai praktikum x 0.70) + (nilai tugas x 0.30)
    nilaiAkhir = (nilaiPraktikum * 0.7) + (nilaiLaporan * 0.3);
    System.out.println("\nNilai Akhir Mahasiswa Praktikum, Nama : "+nama+" adalah "+nilaiAkhir);
  }
  
  @Override
  public void inputData() {
    try {
      System.out.println("\n[INFO] Input data Mahasiswa Praktikum");
      System.out.print("NIM : ");
      NIM = scanner.nextInt();
    
      scanner.nextLine();
      System.out.print("Nama : ");
      nama = scanner.nextLine();
      
      System.out.print("Nilai Praktikum : ");
      nilaiPraktikum = scanner.nextDouble();
      
      System.out.print("Nilai Laporan : ");
      nilaiLaporan = scanner.nextDouble();
    
      System.out.println("\n[INFO] Hasil Input Data Mahasiswa");
      System.out.println("NIM \t:"+NIM);
      System.out.println("Nama \t:"+nama);
      System.out.println("Nilai Praktikum :"+nilaiPraktikum);
      System.out.println("Nilai Laporan :"+nilaiLaporan);
    }
    catch (Exception e) {
      scanner.close();
      System.err.println(e.getMessage());
    }
  }
}
