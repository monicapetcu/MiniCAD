
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Rectangle implements Shape {
    private int xs, ys, lungime, inaltime;
    private Culori rgbContur, rgbFill;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Rectangle() {
    }
    /* Verifica daca este dreptunghi */
    public String isForm() {
        return "R";
    }
    /* Accepta vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }
    public void setLine(final int xstart, final int ystart, final int xfinal, final int yfinal,
            final Culori rgb, final BufferedImage img) {
    }
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setCircle(final int xstart, final int ystart, final int r,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
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
    /* Retine datele dreptunghiului */
    public void setRectangle(final int xstart, final int ystart, final int h, final int lung,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
        xs = xstart;
        ys = ystart;
        inaltime = h;
        lungime = lung;
        rgbContur = rgbcontur;
        rgbFill = rgbfill;
        background = image;
    }
    /* Returneaza coordonata x a punctului de start */
    public int xStart() {
        return xs;
    }
    /* Returneaza coordonata y a punctului de start */
    public int yStart() {
        return ys;
    }
    /* Returneaza dimensiunea inaltimii dreptunghiului */
    public int getInaltime() {
        return inaltime;
    }
    /* Returneaza dimensiunea lungimii dreptunghiului */
    public int getLungime() {
        return lungime;
    }
    /* Returneaza culoarea conturului dreptunghiului */
    public Culori getRGBContur() {
        return rgbContur;
    }
    /* Returneaza culoarea interiorului dreptunghiului */
    public Culori getRGBFill() {
        return rgbFill;
    }
    /* Returneaza imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Deseneaza dreptunghiul */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
