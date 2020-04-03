
import java.io.*;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Point;

public class Main {

    public static void main(final String[] args) {
        File file = new File(args[0]);
        try {
            Scanner read = new Scanner(file);
            File outputfile = new File("drawing.png");
            int n, h, lungime, alphacont, xs, ys, xf, yf, alphaint, raza, nr;
            final int trei = 3;
            String forma, contur, interior;
            n = read.nextInt();
            forma = read.next();
            h = read.nextInt();
            lungime = read.nextInt();
            interior = read.next();
            alphaint = read.nextInt();
            Culori rgb = new Culori(interior, alphaint);
            rgb.getColors();
            BufferedImage image = new BufferedImage(lungime, h, BufferedImage.TYPE_INT_ARGB);
            Singleton canvas = Singleton.getInstance();
            canvas.dimensions(h, lungime);
            image = canvas.createCanvas(rgb);
            for (int i = 0; i < n - 1; i++) {
                forma = read.next();
                Shape s = ShapeFactory.getShape(forma);
                if (s.isForm().equals("L")) {
                    xs = read.nextInt();
                    ys = read.nextInt();
                    xf = read.nextInt();
                    yf = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbLine = new Culori(interior, alphaint);
                    rgbLine.getColors();
                    s.setLine(xs, ys, xf, yf, rgbLine, image);
                    s.draw();
                }
                if (s.isForm().equals("S")) {
                    xs = read.nextInt();
                    ys = read.nextInt();
                    lungime = read.nextInt();
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturS = new Culori(contur, alphacont);
                    Culori rgbFillS = new Culori(interior, alphaint);
                    rgbConturS.getColors();
                    rgbFillS.getColors();
                    s.setSquare(xs, ys, lungime, rgbConturS, rgbFillS, image);
                    s.draw();
                }
                if (s.isForm().equals("R")) {
                    xs = read.nextInt();
                    ys = read.nextInt();
                    h = read.nextInt();
                    lungime = read.nextInt();
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturR = new Culori(contur, alphacont);
                    Culori rgbFillR = new Culori(interior, alphaint);
                    rgbConturR.getColors();
                    rgbFillR.getColors();
                    s.setRectangle(xs, ys, h, lungime, rgbConturR, rgbFillR, image);
                    s.draw();
                }
                if (s.isForm().equals("C")) {
                    xs = read.nextInt();
                    ys = read.nextInt();
                    raza = read.nextInt();
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturC = new Culori(contur, alphacont);
                    Culori rgbFillC = new Culori(interior, alphaint);
                    rgbConturC.getColors();
                    rgbFillC.getColors();
                    s.setCircle(xs, ys, raza, rgbConturC, rgbFillC, image);
                    s.draw();
                }
                if (s.isForm().equals("T")) {
                    Point[] t = new Point[trei];
                    for (int j = 0; j < t.length; j++) {
                        t[j] = new Point(0, 0);
                    }
                    int x, y;
                    for (int j = 0; j < trei; j++) {
                        x = read.nextInt();
                        y = read.nextInt();
                        t[j].setLocation(x, y);
                    }
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturT = new Culori(contur, alphacont);
                    Culori rgbFillT = new Culori(interior, alphaint);
                    rgbConturT.getColors();
                    rgbFillT.getColors();
                    s.setTriangle(t, rgbConturT, rgbFillT, image);
                    s.draw();
                }
                if (s.isForm().equals("D")) {
                    int x, y, oriz, vert;
                    x = read.nextInt();
                    y = read.nextInt();
                    oriz = read.nextInt();
                    vert = read.nextInt();
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturD = new Culori(contur, alphacont);
                    Culori rgbFillD = new Culori(interior, alphaint);
                    rgbConturD.getColors();
                    rgbFillD.getColors();
                    s.setDiamond(x, y, oriz, vert, rgbConturD, rgbFillD, image);
                    s.draw();
                }
                if (s.isForm().equals("P")) {
                    nr = read.nextInt();
                    Point[] p = new Point[nr];
                    for (int j = 0; j < p.length; j++) {
                        p[j] = new Point(0, 0);
                    }
                    int x, y;
                    for (int j = 0; j < nr; j++) {
                        x = read.nextInt();
                        y = read.nextInt();
                        p[j].setLocation(x, y);
                    }
                    contur = read.next();
                    alphacont = read.nextInt();
                    interior = read.next();
                    alphaint = read.nextInt();
                    Culori rgbConturP = new Culori(contur, alphacont);
                    Culori rgbFillP = new Culori(interior, alphaint);
                    rgbConturP.getColors();
                    rgbFillP.getColors();
                    s.setPolygon(nr, p, rgbConturP, rgbFillP, image);
                    s.draw();
                }
            }
            ImageIO.write(image, "png", outputfile);
            read.close();
        } catch (NullPointerException ex) {
            System.err.println("Error!");
            return;
       } catch (IOException e) {
           System.err.println("Error!");
           return;
        }
    }
}
