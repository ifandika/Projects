import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RotateImage {
  /**
   * Memutar gambar dengan sudut tertentu
   * 
   * @param inputPath  path file gambar input
   * @param outputPath path file gambar output
   * @param angle      sudut rotasi dalam derajat (positif = clockwise)
   */
  public static void rotateImage(String inputPath, String outputPath, double angle) {
    try {
      // Baca gambar
      BufferedImage originalImage = ImageIO.read(new File(inputPath));

      // Konversi angle ke radian
      double radian = Math.toRadians(angle);
      double sin = Math.abs(Math.sin(radian));
      double cos = Math.abs(Math.cos(radian));

      // Hitung dimensi baru setelah rotasi
      int originalWidth = originalImage.getWidth();
      int originalHeight = originalImage.getHeight();
      int newWidth = (int) Math.floor(originalWidth * cos + originalHeight * sin);
      int newHeight = (int) Math.floor(originalHeight * cos + originalWidth * sin);

      // Buat gambar baru dengan ukuran yang sesuai
      BufferedImage rotatedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

      // Setup transformasi
      Graphics2D g2d = rotatedImage.createGraphics();

      // Atur kualitas rendering
      g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // Pindahkan origin ke center, rotate, lalu pindahkan kembali
      AffineTransform transform = new AffineTransform();
      transform.translate(newWidth / 2.0, newHeight / 2.0);
      transform.rotate(radian);
      transform.translate(-originalWidth / 2.0, -originalHeight / 2.0);

      // Apply transformasi
      g2d.drawImage(originalImage, transform, null);
      g2d.dispose();

      // Simpan gambar
      String format = outputPath.substring(outputPath.lastIndexOf(".") + 1);
      ImageIO.write(rotatedImage, format, new File(outputPath));

      System.out.println("Rotasi berhasil! Gambar disimpan di: " + outputPath);

    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  // Metode dengan rotasi specifik (90, 180, 270)
  public static void rotate90Clockwise(String inputPath, String outputPath) {
    try {
      BufferedImage original = ImageIO.read(new File(inputPath));
      int width = original.getWidth();
      int height = original.getHeight();

      // Untuk rotasi 90°, cukup swap width dan height
      BufferedImage rotated = new BufferedImage(height, width, original.getType());

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int pixel = original.getRGB(x, y);
          // Rotasi 90° clockwise: (x, y) -> (y, width - x - 1)
          rotated.setRGB(y, width - x - 1, pixel);
        }
      }

      String format = outputPath.substring(outputPath.lastIndexOf(".") + 1);
      ImageIO.write(rotated, format, new File(outputPath));
      System.out.println("Rotasi 90° berhasil!");

    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    String path = "D:\\Ifandika\\Projects\\10_java-rotate-image\\vscode\\";
    String inputFile = path+"img1.jpg";

    // Rotasi 45 derajat
    rotateImage(inputFile, path+"rotated_45.jpg", 45);

    // Rotasi 90 derajat (metode cepat)
    rotate90Clockwise(inputFile, path+"rotated_90.jpg");

    // Rotasi 180 derajat
    rotateImage(inputFile, path+"rotated_180.jpg", 180);

    // Rotasi 270 derajat
    rotateImage(inputFile, path+"rotated_270.jpg", 270);
  }
}