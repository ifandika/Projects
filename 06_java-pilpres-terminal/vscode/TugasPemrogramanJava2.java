import java.util.*;

/**
 * Kelas ini adalah kelas utama yang berisi program pemilihan calon dan wakil presiden berbasis input
 * interaktif dari pengguna lewat terminal.
 * - Menampilkan data calon dan wakil presiden
 * - Input pemilih dengan data Nama, Identitas/Lembaga, No urut yang dipilih
 * - Fungsi rekapitulasi data untuk menampilkan statistik data: jumlah suara masing2 paslon,
 *   jumlah suara terbanyak dan tersedikit
 */
public class TugasPemrogramanJava2 {
  /**
   * Deklarasi variabel global kelas
   * - {@code dataPresiden} Untuk simpan data calon dan wakil presiden
   * - {@code dataPemilih} Untuk simpan data pemilih
   * - {@code CODE_NO, CODE_CALONPRESIDEN, CODE_WAKILPRESIDEN} Untuk index kolom data calon dan wakil presiden
   * - {@code scanner} Untuk input sistem
   * - {@code header} Untuk menampilkan header tabel data presiden
   * - {@code dataPresiden1, dataPresiden2, dataPresiden3} Untuk string hasil ektrak data agar lebih mudah ditampilkan
   */
  private static ArrayList<ArrayList<Object>> dataPresiden = new ArrayList<>();
  private static ArrayList<ArrayList<Object>> dataPemilih = new ArrayList<>();
  private static final int CODE_NO = 0;
  private static final int CODE_CALONPRESIDEN = 1;
  private static final int CODE_WAKILPRESIDEN = 2;
  private static Scanner scanner = new Scanner(System.in);
  private static final String header = "| No Urut | Calon Presiden | Wakil Presiden |";
  private static String dataPresiden1 = null;
  private static String dataPresiden2 = null;
  private static String dataPresiden3 = null;

  /**
   * Fungsi ini untuk input data pemilihan presiden
   * - Kita deklarasi arrayList objek dengan kita isi nilai null
   * - Lalu input dengan langsung set arrayList pada index
   * - Kita buat kondisi switch untuk memasukan data presiden berdasarkan input no urut yang dipilih
   * - Kembalikan variabel objek arrayList
   * @return
   */
  public static ArrayList<Object> pilihPresiden() {
    ArrayList<Object> pemilihPresiden = new ArrayList<>(5);
    for(int i = 0; i < 5; i++) {
      pemilihPresiden.add(i, null);
    }
    /**
     * - No urut
     * - Calon presiden
     * - Wakil presiden
     * - Identitas
     * - Nama pemilih
     */
    System.out.println("\n[INFO] Silahkan pilih Calon dan Wakil Presiden:");
    System.out.print("Masukan nama: ");
    pemilihPresiden.set(4, scanner.nextLine());
    System.out.print("Masukan identitas instansi/lembaga: ");
    pemilihPresiden.set(3, scanner.nextLine());
    System.out.print("Masukan No. Urut [1-3]: ");
    pemilihPresiden.set(0, Integer.parseInt(scanner.next()));

    switch(Integer.parseInt(String.valueOf(pemilihPresiden.get(0)))) {
      case 0:
        pemilihPresiden.set(1, dataPresiden.get(0).get(1));
        pemilihPresiden.set(2, dataPresiden.get(0).get(2));
        break;
      case 1:
        pemilihPresiden.set(1, dataPresiden.get(1).get(1));
        pemilihPresiden.set(2, dataPresiden.get(1).get(2));
        break;
      case 2:
        pemilihPresiden.set(1, dataPresiden.get(2).get(1));
        pemilihPresiden.set(2, dataPresiden.get(2).get(2));
        break;
      default:
    }

    return pemilihPresiden;
  }

  /**
   * Fungsi ini untuk statistik data pemilihan presiden
   * # Jumlah banyak pemilih Presiden 1, 2, 3
   * - Kita tampilkan info untuk data total pemillih
   * - Deklarasi variabel untuk jumlah suara per-paslon
   * - Perulangan untuk menjumlahkan data tiap paslon
   * - Lalu kita tampilkan data jumlah suara
   * 
   * # Jumlah pemilih presiden terbanyak, tersedikit
   * - Kita buat List berisi jumlah suara paslon
   * - Ambil data max dan min dengan fungsi dari Collections
   * - Tampilkan suara terbanyak dan tersedikit dengan kondisi
   */
  public static void rekapitulasiData() {
    System.out.println("[INFO] Data total pemilih tiap Pasangan Calon");
    int totalPaslon1 = 0;
    int totalPaslon2 = 0;
    int totalPaslon3 = 0;

    for(int i = 0; i < dataPemilih.size(); i++) {
      int pemilih = Integer.parseInt(String.valueOf(dataPemilih.get(i).get(0)));
      if(pemilih == 1) {
        totalPaslon1++;
      }
      if(pemilih == 2) {
        totalPaslon2++;
      }
      if(pemilih == 3) {
        totalPaslon3++;
      }
    }

    System.out.println("Calon dan Wakil Presiden No. 1 : "+totalPaslon1);
    System.out.println("Calon dan Wakil Presiden No. 2 : "+totalPaslon2);
    System.out.println("Calon dan Wakil Presiden No. 3 : "+totalPaslon3);

    List<Integer> listTotalSuara = List.of(totalPaslon1, totalPaslon2, totalPaslon3);
    int maxSuara = Collections.max(listTotalSuara);
    int minSuara = Collections.min(listTotalSuara);

    System.out.println("\n[INFO]Data suara terbanyak dan terdikit Calon dan Wakil Presiden");
    if(maxSuara == totalPaslon1) {
      System.out.println("Data suara terbayak pada Calon dan Wakil No. Urut : "+1);
      System.out.println(dataPresiden1);
    }
    if(maxSuara == totalPaslon2) {
      System.out.println("Data suara terbayak pada Calon dan Wakil No. Urut : "+2);
      System.out.println(dataPresiden2);
    }
    if(maxSuara == totalPaslon3) {
      System.out.println("Data suara terbayak pada Calon dan Wakil No. Urut : "+3);
      System.out.println(dataPresiden3);
    }

    if(minSuara == totalPaslon1) {
      System.out.println("Data suara terdikit pada Calon dan Wakil No. Urut : "+1);
      System.out.println(dataPresiden1);
    }
    if(minSuara == totalPaslon2) {
      System.out.println("Data suara terdikit pada Calon dan Wakil No. Urut : "+2);
      System.out.println(dataPresiden2);
    }
    if(minSuara == totalPaslon3) {
      System.out.println("Data suara terdikit pada Calon dan Wakil No. Urut : "+3);
      System.out.println(dataPresiden3);
    }
  }

  public static void main(String[] args) {
    // Tambahkan data ke arrayList
    dataPresiden.add(new ArrayList<>(List.of(1, "Azhar Hardian", "Guardian")));
    dataPresiden.add(new ArrayList<>(List.of(2, "Iqbal Rajalele", "Hakim Sing")));
    dataPresiden.add(new ArrayList<>(List.of(3, "Ridho Al Katiri", "Zaenal")));

    // Kita ekstrak
    dataPresiden1 = "| "+dataPresiden.get(0).get(CODE_NO)+" | "+dataPresiden.get(0).get(CODE_CALONPRESIDEN)+" | "+dataPresiden.get(0).get(CODE_WAKILPRESIDEN)+" | ";
    dataPresiden2 = "| "+dataPresiden.get(1).get(CODE_NO)+" | "+dataPresiden.get(0).get(CODE_CALONPRESIDEN)+" | "+dataPresiden.get(0).get(CODE_WAKILPRESIDEN)+" | ";
    dataPresiden3 = "| "+dataPresiden.get(2).get(CODE_NO)+" | "+dataPresiden.get(0).get(CODE_CALONPRESIDEN)+" | "+dataPresiden.get(0).get(CODE_WAKILPRESIDEN)+" | ";

    // Kondisi untuk program utama agar tetap berjalan
    boolean condition = true;
    while(condition) {
      System.out.println("\n[INFO] Selamat Memilih Calon dan Wakil Presiden");
      System.out.println(header);
      System.out.println(dataPresiden1);
      System.out.println(dataPresiden2);
      System.out.println(dataPresiden3);

      // Input pemilihan presiden
      ArrayList<Object> result = pilihPresiden();
      dataPemilih.add(result);
      System.out.println("[INFO] Berhasil memasukan data pemilih...");

      // Lanjut input ?
      System.out.print("Lanjut Y/n: ");
      char yesOrNo = scanner.next().charAt(0);
      scanner.nextLine();
      if(yesOrNo != 'Y' && yesOrNo != 'y') {
        condition = false;
      }
    }

    // Data statistik suara pemilihan presiden
    System.out.println("\n[INFO] Hasil data pemilihan presiden");
    rekapitulasiData();

    // Program berakhir dan kita tutup objek scanner
    System.out.println("\n[INFO] Program berakhir");
    scanner.close();
  }
}
