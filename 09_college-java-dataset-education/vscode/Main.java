import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is main class for program
 */
public class Main {
  /**
   * Declaration of all that is needed
   */
  private static Master master = new Master();
  private static Provinsi provinsi = new Provinsi();
  private static BPS bps = new BPS();
  private static Pendidikan pendidikan = new Pendidikan();
  private static Scanner scanner = new Scanner(System.in);
  private static boolean mainContition = true;

  // == Main Method ==
  public static void main(String[] args) {
    try {
      // Add the data set
      master.addData(new ArrayList<>(List.of(1, 11, 11, "Aceh", 118.487D, 19.170D, 137.657D)));  
      master.addData(new ArrayList<>(List.of(2, 12, 12, "Sumatera Utara", 248.734D, 141.165D, 389.899D)));  
      master.addData(new ArrayList<>(List.of(3, 13, 13, "Sumatera Barat", 138.979D, 14.556D, 153.535D)));  
      master.addData(new ArrayList<>(List.of(4, 14, 14, "Riau", 148.011D, 24.248D, 172.295D)));
      master.addData(new ArrayList<>(List.of(4, 15, 15, "Jambi", 71.000D, 10.429D, 81.429D)));

      while(mainContition) {
        // Print program main menu
        System.out.println("\n[ Menu Utama ]");
        System.out.println("1. Cari Provinsi");
        System.out.println("2. Kode BPS");
        System.out.println("3. Status Satuan Pendidikan Negeri");
        System.out.print("\nPilih menu [1-3]: ");

        // Get input
        int inputMenu = scanner.nextInt();

        // Check input menu
        if(inputMenu == 1) {
          ArrayList<Object> resProv = provinsi.cariProvinsi(master.getDataSet());

          System.out.println("[ Data Provinsi ]");
          System.out.println("| No | Kode Kemdagri | Kode BPS | Provinsi | SSP Negeri | SSP Swasta | Total |");
          System.out.println("| "+resProv.get(0)+" | "+resProv.get(1)+" | "+resProv.get(2)+" | "+resProv.get(3)+" | "+resProv.get(4)+" | "+resProv.get(5)+" | "+resProv.get(6)+" | ");
        }
        else if(inputMenu == 2) {
          ArrayList<Object> resBPS = bps.cariKodeBPS(master.getDataSet());

          System.out.println("[ Data BPS ]");
          System.out.println("| No | Kode Kemdagri | Kode BPS | Provinsi | SSP Negeri | SSP Swasta | Total |");
          System.out.println("| "+resBPS.get(0)+" | "+resBPS.get(1)+" | "+resBPS.get(2)+" | "+resBPS.get(3)+" | "+resBPS.get(4)+" | "+resBPS.get(5)+" | "+resBPS.get(6)+" | ");
        }
        else if(inputMenu == 3) {
          ArrayList<ArrayList<Object>> resPen = pendidikan.cariSatuanPendidikanNegeri(master.getDataSet());
          
          System.out.println("[ Data Satuan Pendidikan Negeri ]");
          System.out.println("| No | Kode Kemdagri | Kode BPS | Provinsi | SSP Negeri | SSP Swasta | Total |");
          for(ArrayList<Object> object : resPen) {
            System.out.println("| "+object.get(0)+" | "+object.get(1)+" | "+object.get(2)+" | "+object.get(3)+" | "+object.get(4)+" | "+object.get(5)+" | "+object.get(6)+" | ");
          }
        }
        else {
          System.out.println("[INFO] Menu tidak ditemukan");
        }

        // Continue program or stop ?
        System.out.print("\nLanjut Y/n: ");
        scanner.nextLine();
        char inputContinue = scanner.next().charAt(0);

        if(inputContinue != 'Y' && inputContinue != 'y') {
          mainContition = false;
          break;
        }
      }
    }
    catch (Exception e) {
      scanner.close();
      System.err.println(e.getMessage());
    }
  }
}