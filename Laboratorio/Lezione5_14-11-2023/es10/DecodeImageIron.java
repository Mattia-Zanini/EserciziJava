
/*
 * L'immagine iron-puzzle.png contiene l'immagine di qualcosa di famoso, ma l'immagine
 * e' stata distorta. L'oggetto famoso e' nei valori di rosso, tuttavia i valori di rosso
 * sono stati tutti divisi per 10, quindi sono tutti piu' piccoli di un fattore 10.
 * I valori di blue e verde sono valori casuali senza significato ("rumore") aggiunti
 * per oscurare l'immagine reale. Il tuo compito e' "disfare" tutte queste distorsioni
 * per rivelare l'immagine reale e scoprire la prima tappa del viaggio di zia Bettina.
 * Innanzitutto metti tutti i valori di blu e verde a 0, per eliminarli. Guarda il
 * risultato... se guardi bene puoi gia' vedere la vera immagine, anche se e' molto scura.
 * Quindi moltiplica ogni valore di rosso per 10 ripristinandolo al valore originale.
 * Di che oggetto famoso si tratta?
 */

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

public class DecodeImageIron {
   public static void main(String args[]) throws IOException {

      if (args.length != 2) {
         System.out.println("Usage: java DecodeImageIron inputFileName outputFileName");
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
            red = red * 10;
            green = 0;
            blue = 0;

            pixelColor = new Color(red, green, blue);

            img.set(x, y, pixelColor);
            //System.out.printf("(%d,%d): %s\n", x, y, img.get(x, y).toString());
         }
      }

      // Saving the modified image
      img.save(args[1]);
      System.out.println("Done...");
   }
}