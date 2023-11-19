import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/* Usare costruttore e metodi della classe SimpleImage
   (fate riferimento alla classe per la descrizione):

public SimpleImage(String filename)
public int height() 
public int width() 
public Color get(int i, int j) 
public void set(int i, int j, Color c)

e i metodi della classe color
public int getRed()
public int getGreen()
public int getBlue()
e il costruttore Color(int r, int g, int b)

*/

public class DecodeImage {
   public static void main(String args[]) throws IOException {

      if (args.length != 2) {
         System.out.println("Usage: java DecodeImage inputFileName outputFileName");
         System.exit(0);
      }

      // Creo oggetto SimpleImage con l'immagine di input
      SimpleImage img = new SimpleImage(args[0]);

      for (int x = 0; x < img.width(); x++) {
         for (int y = 0; y < img.height(); y++) {
            Color pixelColor = img.get(x, y);
            int red = pixelColor.getRed();
            int green = pixelColor.getGreen();
            int blue = pixelColor.getBlue();

            // modifica ai colori

            pixelColor = new Color(red, green, blue);

            img.set(x, y, pixelColor);
            // System.out.printf("(%d,%d): %s\n", x, y, img.get(x, y).toString());
         }
      }

      // Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");
   }
}