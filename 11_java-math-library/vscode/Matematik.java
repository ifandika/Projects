import java.math.*;

public class Matematik {
  public static final double PI = 3.14159265359d;


  /**
   * ==================================================================
   * Number
   * 
   */
  public static void printOriginalNumber() {
    System.out.println("Original Number : 1, 2, 3, 4, 5, ...");
  }

  public static void printWholeNumber() {
    System.out.println("Whole Number : 0, 1, 2, 3, 4, 5, ...");
  }

  public static void printIntegerNumber() {
    System.out.println("Whole Number : -2, -1, 0, 1, 2, 3, 4, 5, ...");
  }

  public static void printRationalNumber() {
    System.out.println("Rational Number : -2, 0, 2^2, 1/2, 10.998, 4, ...");
  }

  public static void printIrationalNumber() {
    System.out.println("Irational Number : π, φ, e, ...");
  }

  public static void printRealNumber() {
    printOriginalNumber();
    printWholeNumber();
    printIntegerNumber();
    printRationalNumber();
    printIrationalNumber();
  }

  /**
   * ==================================================================
   * Eksponen
   */
  public static double[] eksponenPerkalianBasisSama(double a, double aPowe1, double aPower2) {
    double[] result = new double[2];
    result[0] = Math.pow(a, (aPowe1 + aPower2));
    return result;
  }

  public static double[] eksponenPembagianBasisSama(double a, double aPowe1, double aPower2) {
    if(a <= 0) {
      System.err.println("Nilai a <= 0");
      return null;
    }
    double[] result = new double[2];
    result[0] = Math.pow(a, (aPowe1 - aPower2));
    return result;
  }

  public static double[] eksponenPangkatDariPangkat(double a, double m, double n) {
    double[] result = new double[2];
    result[0] = Math.pow(a, (m * n));
    return result;
  }

  public static double[] eksponenPangkatDariPerkalian(double a, double b, double n) {
    double[] result = new double[2];
    a = Math.pow(a, n);
    b = Math.pow(b, n);
    result[0] = a * b;
    return result;
  }

  public static double[] eksponenPangkatDariPembagian(double a, double b, double n) {
    double[] result = new double[2];
    a = Math.pow(a, n);
    b = Math.pow(b, n);
    result[0] = a;
    result[1] = b;
    return result;
  }






  /**
   * Fungsi untuk check sistem desimal pada bilangan,
   * Contoh: 3.245
   * - 3 : satuan
   * - 2 : puluhan
   * - 4 : ratusan
   * - 5 : ribuan
   * @param number
   */
  public static void decimalSystemCheck(int number) {
    String numberToString = String.valueOf(number);

    for(int i = 0; i < numberToString.length(); i++) {
      char wordNumber = numberToString.charAt(i);
      if(i == 0) {
        System.out.println("Value "+wordNumber+" is a Unit");
      }
      else if(i == 1) {
        System.out.println("Value "+wordNumber+" is a Dozens");
      }
      else if(i == 2) {
        System.out.println("Value "+wordNumber+" is a Hundreds");
      }
      else if(i == 3) {
        System.out.println("Value "+wordNumber+" is a Thousands");
      }
      else if(i == 4) {
        System.out.println("Value "+wordNumber+" is a Milions");
      }
      else if(i == 5) {
        System.out.println("Value "+wordNumber+" is a Bilions");
      }
      else if(i == 6) {
        System.out.println("Number is to large...");
        break;
      }
    }
  }
  




  /**
   * Fungsi matematika untuk modulo
   * @param operandA    Untuk nilai pertama
   * @param operandB    Untuk nilai kedua
   * @return
   */
  public static double modulo(double operandA, double operandB) {
    return (operandA % operandB);
  }

  /**
   * Fungsi matematika untuk pengurangan
   * @param operandA    Untuk nilai pertama
   * @param operandB    Untuk nilai kedua
   * @return
   */
  public static double minus(double operandA, double operandB) {
    return (operandA - operandB);
  }

  /**
   * Fungsi matematika untuk penjumlahan
   * @param operandA    Untuk nilai pertama
   * @param operandB    Untuk nilai kedua
   * @return
   */
  public static double plus(double operandA, double operandB) {
    return (operandA + operandB);
  }

  /**
   * Fungsi matematika untuk perkalian
   * @param operandA    Untuk nilai pertama
   * @param operandB    Untuk nilai kedua
   * @return
   */
  public static double multiplication(double operandA, double operandB) {
    return (operandA * operandB);
  }

  /**
   * Fungsi matematika sigma linear (naik)
   * @param n   Batas jumlah nilai
   * @param i   Mulai dari nilai
   * @return
   */
  public static double sigmaLinear(int n, int i) {
    int sum = 0;
    for(int order = i; order <= n; order++) {
      sum += order;
    }
    return sum;
  }
}
