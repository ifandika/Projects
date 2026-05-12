import java.util.ArrayList;
import java.util.Scanner;

public class Provinsi extends Master {
  
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
