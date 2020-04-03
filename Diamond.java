
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Diamond implements Shape {
    private int x, y, oriz, vert;
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Diamond() {
    }
    /* Verifica daca este romb */
    public String isForm() {
        return "D";
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
    public void setPolygon(final int nrPct, final Point[] points, final Culori rgbcontur,
            final Culori rgbfill, final BufferedImage image) {
    }
    /* Retine datele rombului */
    public void setDiamond(final int xmij, final int ymij, final int diagoriz,
            final int diagvert, final Culori rgbcontur, final Culori rgbfill,
            final BufferedImage image) {
        x = xmij;
        y = ymij;
        oriz = diagoriz;
        vert = diagvert;
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza coordonata y a mijlocului rombului */
    public int gety() {
        return y;
    }
    /* Returneaza lungimea diagonalei orizontale a rombului */
    public int getOriz() {
        return oriz;
    }
    /* Returneaza lungimea diagonalei verticale a rombului */
    public int getVert() {
        return vert;
    }
    /* Returneaza coordonata y a mijlocului rombului */
    public int getx() {
        return x;
    }
    /* Returneaza culoarea conturului rombului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului rombului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza rombul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
