import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is for data education that have one method.
 */
public class Pendidikan extends Master {

  /**
   * This method is for search data education country, and return value is double arrayList
   * - Initial variable
   * - Print message and get input
   * - Check range input and assign variable
   * - Looping data with range data conditions, if true add data
   * - Return result
   * @param data
   * @return
   */
  public ArrayList<ArrayList<Object>> cariSatuanPendidikanNegeri(ArrayList<ArrayList<Object>> data) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<ArrayList<Object>> result = new ArrayList<>();

    System.out.println("\n[ Menu Cari Satuan Pendiikan Negeri ]");
    System.out.println("Pilih kondisi: ");
    System.out.println("1. Antara 10.000 - 70.000");
    System.out.println("2. Antara 70.000 - 140.000");
    System.out.println("3. Antara 140.000 - 210.000");
    System.out.println("4. Antara 210.000 - 280.000");
    System.out.print("Pilih kondisi [1-4]: ");
    int inputNilaiKondisi = scanner.nextInt();

    double range1 = 0, range2 = 0;

    switch (inputNilaiKondisi) {
      case 1:
        range1 = 10.000;
        range2 = 70.000;
        break;
      case 2:
        range1 = 70.000;
        range2 = 140.000;
        break;
      case 3:
        range1 = 140.000;
        range2 = 210.000;
        break;
      case 4:
        range1 = 210.000;
        range2 = 280.000;
        break;
      default:
        break;
    }

    for(ArrayList<Object> object : data) {
      double negeri = Double.parseDouble(String.valueOf(object.get(4)));
      if(negeri >= range1 && negeri <= range2) {
        result.add(object);
      }
    }
    return result;
  }
}
