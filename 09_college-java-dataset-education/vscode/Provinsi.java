import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is for data province, have one method.
 */
public class Provinsi extends Master {
  
  /**
   * This method is for search data province, return value is arrayList
   * - Initali variable
   * - Print message and get input
   * - Looping and comparing data
   * - If true return data and or no return null
   * @param data
   * @return
   */
  public ArrayList<Object> cariProvinsi(ArrayList<ArrayList<Object>> data) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n[ Menu Cari Provinsi ]");
    System.out.print("Masukan nama provinsi: ");
    String provinsiInput = scanner.nextLine();

    for(ArrayList<Object> object : data) {
      if(String.valueOf(object.get(3)).equals(provinsiInput)) {
        return object;
      }
    }
    return null;
  }
}
