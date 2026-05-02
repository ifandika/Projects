import java.util.*;

/**
 * By M. Ifandika - 2026
 * https://ifandika.github.io
 * This is main class
 * 
 * This class contains 2 method, tambahData(x) and the main function to run program.
 */
public class P6_Ebook {
  /**
   * This is declare global variable that use for this program
   * - scanner : For system input
   * - dataEbooks : For store all data ebook
   * - informationEbook : Object class P6_InformationEbook
   */
  private static final Scanner scanner = new Scanner(System.in);
  private static final ArrayList<ArrayList<String>> dataEbooks = new ArrayList<>();
  private static final P6_InformasiEbook informasiEbook = new P6_InformasiEbook();

  /**
   * This method for add data with input value from paremeter value, then save to single ArrayList<String> and then
   * return the ArrayList.
   * @param id
   * @param judul
   * @param penerbit
   * @param tahunTerbit
   * @param penulis
   * @return
   */
  public static ArrayList<String> tambahData(String id, String judul, String penerbit, String tahunTerbit, String penulis) {
    ArrayList<String> newEbook = new ArrayList<>();

    newEbook.add(id);
    newEbook.add(judul);
    newEbook.add(penerbit);
    newEbook.add(tahunTerbit);
    newEbook.add(penerbit);

    return newEbook;
  }

  /**
   * This is MAIN FUNCTION
   * @param args
   */
  public static void main(String[] args) {
    try {
      System.out.println("[ Ebook ]");
      System.out.println("[INFO] Masukan data Ebook:");
      
      /**
       * 0 = ID
       * 1 = Judul
       * 2 = Penerbit
       * 3 = Tahun Terbit
       * 4 = Penulis
      */
      ArrayList<String> newEbook = new ArrayList<>();
      /**
       * ==== TAMBAH DATA EBOOK ====
       */
      System.out.print("Masukan data ID: ");
      newEbook.add(scanner.nextLine());
      
      System.out.print("Masukan data Judul: ");
      newEbook.add(scanner.nextLine());
      
      System.out.print("Masukan data Penerbit: ");
      newEbook.add(scanner.nextLine());
      
      System.out.print("Masukan data Tahun Terbit: ");
      newEbook.add(scanner.nextLine());
      
      System.out.print("Masukan data Penulis: ");
      newEbook.add(scanner.nextLine());
      
      dataEbooks.add(newEbook);
      
      /**
       * ==== SCAN DATA EBOOK ====
       */
      System.out.println("\n[INFO] Scan data EBook:");
      informasiEbook.scan(dataEbooks);
      
      /**
       * ==== CARI DATA EBOOK ====
       */
      System.out.println("\n[INFO] Cari data EBook:");
      System.out.print("Masukan data Judul: ");
      String judul = scanner.nextLine();
      
      System.out.print("Masukan data Penerbit: ");
      String penerbit = scanner.nextLine();

      informasiEbook.cariData(judul, penerbit, dataEbooks);
    }
    catch (Exception e) {
      scanner.close();
      System.err.println(e.toString());
    }
  }
}