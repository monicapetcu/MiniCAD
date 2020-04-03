
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Triangle implements Shape {
        private final static int TREI = 3;
    Point[] p = new Point[TREI];
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Triangle() {
    }
    /* Verifica daca este triunghi */
    public String isForm() {
        return "T";
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
    public void setDiamond(final int xmij, final int ymij, final int diagoriz,
            final int diagvert, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
    }
    /* Accepta vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setPolygon(final int nrPct, final Point[] points, final Culori rgbcontur,
            final Culori rgbfill, final BufferedImage image) {
    }
    /* Retine datele triunghiului */
    public void setTriangle(final Point[] points, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
        for (int i = 0; i < TREI; i++) {
            p[i] = new Point(0, 0);
            p[i].setLocation(points[i].x, points[i].y);
        }
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza un vector care retine coordonatele varfurilor triunghiului */
    public Point[] getPoints() {
        return p;
    }
    /* Returneaza culoarea conturului triunghiului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului triunghiului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza triunghiul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
