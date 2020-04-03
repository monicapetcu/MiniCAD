
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Polygon implements Shape {
    private int nr;
    private final static int CINCISUTE = 500;
    Point[] p = new Point[CINCISUTE];
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Polygon() {
    }
    /* Verifica daca este poligon */
    public String isForm() {
        return "P";
    }
    /* Accepta vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }
    public void setLine(final int xstart, final int ystart, final int xfinal, final int yfinal,
            final Culori rgb, final BufferedImage img) {
    }
    public void setRectangle(final int xstart, final int ystart, final int h, final int lung,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setCircle(final int xstart, final int ystart, final int r,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setTriangle(final Point[] points, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
    }
    public void setDiamond(final int xmij, final int ymij, final int diagoriz,
            final int diagvert, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
    }
    /* Retin datele poligonului */
    public void setPolygon(final int nrPct, final Point[] points, final Culori rgbcontur,
            final Culori rgbfill, final BufferedImage image) {
        nr = nrPct;
        for (int i = 0; i < nr; i++) {
            p[i] = new Point(0, 0);
            p[i].setLocation(points[i].x, points[i].y);
        }
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza un vector ce retine coordonatele punctelor */
    public Point[] getPoints() {
        return p;
    }
    /* Returneaza culoarea conturului poligonului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului poligonului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza numarul de varfuri ale poligonului */
    public int nr() {
        return nr;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza poligonul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
