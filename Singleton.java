
import java.awt.Color;
import java.awt.image.BufferedImage;

final class Singleton {

       private static Singleton canvas = new Singleton();
       private int inaltime, lungime;

       private Singleton() {
       }

       public static Singleton getInstance() {
          return canvas;
       }

       public void dimensions(final int h, final int lung) {
          inaltime = h;
          lungime = lung;
       }

       public BufferedImage createCanvas(final Culori rgb) {
           BufferedImage image = new BufferedImage(lungime, inaltime,
                   BufferedImage.TYPE_INT_ARGB);
           Color background = new Color(rgb.getRed(), rgb.getGreen(),
                   rgb.getBlue(), rgb.getAlpha());
           for (int i = 0; i < inaltime; i++) {
               for (int j = 0; j < lungime; j++) {
                   image.setRGB(j, i, background.getRGB());
               }
           }
           return image;
       }
}
