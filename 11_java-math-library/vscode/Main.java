import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Matematik.decimalSystemCheck(345432);

    System.out.println("Eksponen perkalian basis sama 2^3 x 2^4 = 128");
    System.out.println(Arrays.toString(Matematik.eksponenPerkalianBasisSama(2, 3, 4)));

    System.out.println("Eksponen pembagian basis sama 3^5 / 3^2 = 27");
    System.out.println(Arrays.toString(Matematik.eksponenPembagianBasisSama(3, 5, 2)));
  }
}
