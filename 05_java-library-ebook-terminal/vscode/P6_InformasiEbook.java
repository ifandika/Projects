import java.util.*;

/**
 * By M. Ifandika - 2026
 * https://ifandika.github.io
 * This is a external class that contains method for operation ebooks
 * 
 * This class contains 2 method is a scan(x) and then cariData(x) 
 */
public class P6_InformasiEbook {
  /**
   * This is declare global variable that use for this class
   * - INDEX_ID : for atribut ID
   * - INDEX_JUDUL : for atribut Judul
   * - INDEX_PENERBIT : for atribut Penerbit
   * - INDEX_TAHUNTERBIT : for atribut Tahun Terbit
   * - INDEX_PENULIS : for atribut Penulis
   */
  private final int INDEX_ID = 0;
  private final int INDEX_JUDUL = 1;
  private final int INDEX_PENERBIT = 2;
  private final int INDEX_TAHUNTERBIT = 3;
  private final int INDEX_PENULIS = 4;

  /**
   * This class is for scan or print or show all data ebook, using for loop then print data by atribute
   * @param dataEbooks
   */
  public void scan(ArrayList<ArrayList<String>> dataEbooks) {
    for(ArrayList<String> ebook : dataEbooks) {
      System.out.println("Data ID \t\t : "+ebook.get(INDEX_ID));
      System.out.println("Data Judul \t\t : "+ebook.get(INDEX_JUDUL));
      System.out.println("Data Penerbit \t\t : "+ebook.get(INDEX_PENERBIT));
      System.out.println("Data Tahun Terbit \t : "+ebook.get(INDEX_TAHUNTERBIT));
      System.out.println("Data Penulis \t\t : "+ebook.get(INDEX_PENULIS));
    }
  }
  
  /**
   * This method is for search data by Judul (Title) and Penerbit (Publish) and then data ebooks, the
   * return is print message.
   * @param judul
   * @param penerbit
   * @param dataEbooks
   */
  public void cariData(String judul, String penerbit, ArrayList<ArrayList<String>> dataEbooks) {
    for(ArrayList<String> ebook : dataEbooks) {
      if(ebook.get(INDEX_JUDUL).equalsIgnoreCase(judul) && ebook.get(INDEX_PENERBIT).equalsIgnoreCase(penerbit)) {
        System.out.println("\n[INFO] Data Ebook dengan Judul : "+judul+", Penerbit : "+penerbit+" ditemukan!");
        return;
      }
    }
    System.out.println("\n[INFO] Data Ebook dengan Judul : "+judul+", Penerbit : "+penerbit+" tidak ditemukan!");
  }
}