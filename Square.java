
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Square implements Shape {
    private int xs, ys, latura;
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Square() {
    }
    /* Verifica daca este patrat */
    public String isForm() {
        return "S";
    }
    public void setLine(final int xstart, final int ystart, final int xfinal, final int yfinal,
            final Culori rgb, final BufferedImage img) {
    }
    public void setRectangle(final int xstart, final int ystart, final int h, final int lung,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setCircle(final int xstart, final int ystart, final int r, final Culori rgbcontur,
            final Culori rgbfill, final BufferedImage image) {
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
    /* Accepta vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }
    /* Retine datele patratului */
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
        xs = xstart;
        ys = ystart;
        latura = lat;
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza coordonata x a punctului de pornire */
    public int xStart() {
        return xs;
    }
    /* Returneaza coordonata y a punctului de pornire */
    public int yStart() {
        return ys;
    }
    /* Returneaza lungimea laturii patratului */
    public int getLatura() {
        return latura;
    }
    /* Returneaza culoarea conturului patratului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului patratului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza patratul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
