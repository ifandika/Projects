import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is for data BPS, that have one method to search data by BPS code.
 */
public class BPS extends Master {

  /**
   * This function is to search data by using BPS code.
   * - Inital scanner for input
   * - Print message and get input
   * - Loop data and check data by comparing data
   * @param data
   * @return
   */
  public ArrayList<Object> cariKodeBPS(ArrayList<ArrayList<Object>> data) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n[ Menu Cari Kode BPS ]");
    System.out.print("Masukan kode BPS: ");
    int kodeBPSInput = scanner.nextInt();

    for(ArrayList<Object> object : data) {
      if(Integer.parseInt(String.valueOf(object.get(2))) == kodeBPSInput) {
        return object;
      }
    }
    return null;
  }
}
