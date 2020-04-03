
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Circle implements Shape {
    private int xs, ys, raza;
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Circle() {
    }
    /* Verifica daca este cerc */
    public String isForm() {
        return "C";
    }
    /* Accept vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }

    public void setLine(final int xstart, final int ystart, final int xfinal, final int yfinal,
            final Culori rgb, final BufferedImage img) {
    }
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setRectangle(final int xstart, final int ystart, final int h,
            final int lung, final Culori rgbcontur, final Culori rgbfill,
 final BufferedImage image) {
    }
    public void setTriangle(final Point[] p, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
    }
    public void setDiamond(final int xmij, final int ymij, final int diagoriz,
            final int diagvert, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
    }
    public void setPolygon(final int nrPct, final Point[] points, final Culori rgbcontur,
            final Culori rgbfill, final BufferedImage image) {
    }
    /* Retine datele cercului */
    public void setCircle(final int xstart, final int ystart, final int r,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
        xs = xstart;
        ys = ystart;
        raza = r;
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza coordonata x a centrului cercului */
    public int xStart() {
        return xs;
    }
    /* Returneaza coordonata y a centrului cercului */
    public int yStart() {
        return ys;
    }
    /* Returneaza raza cercului */
    public int getRaza() {
        return raza;
    }
    /* Returneaza culoarea conturului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza cercul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
