import java.util.ArrayList;
import java.util.Scanner;

public class BPS extends Master {

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
