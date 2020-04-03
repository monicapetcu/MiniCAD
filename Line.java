
import java.awt.image.BufferedImage;
import java.awt.Point;

public class Line implements Shape, Accept {
    private int xs, ys, xf, yf;
    private Culori rgbLinie;
    private BufferedImage background;
    private DrawVisitor drawvisit = new DrawVisitor();
    public Line() {
    }
    public void setSquare(final int xstart, final int ystart, final int lat,
            final Culori rgbcontur, final Culori rgbfill, final BufferedImage image) {
    }
    public void setRectangle(final int xstart, final int ystart, final int h, final int lung,
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
    /* Accept vizitator */
    public void accept(final Visitor v) {
        v.visit(this);
    }
    /* Verifica daca este linie */
    public String isForm() {
        return "L";
    }
    /* Retine datele liniei */
    public void setLine(final int xstart, final int ystart, final int xfinal, final int yfinal,
        final Culori rgb, final BufferedImage image) {
        xs = xstart;
        ys = ystart;
        xf = xfinal;
        yf = yfinal;
        rgbLinie = rgb;
        background = image;
    }
    /* Returnez coordonata x a punctului de pornire */
    public int xStart() {
        return xs;
    }
    /* Returnez coordonata y a punctului de pornire */
    public int yStart() {
        return ys;
    }
    /* Returnez coordonata x a punctului de sosire */
    public int xFinal() {
        return xf;
    }
    /* Returnez coordonata y a punctului de sosire */
    public int yFinal() {
        return yf;
    }
    /* Returnez culoarea liniei */
    public Culori getRGB() {
        return rgbLinie;
    }
    /* Returnez imaginea */
    public BufferedImage getBg() {
        return background;
    }
    /* Desenez linia */
    @Override
    public void draw() {
        this.accept(drawvisit);
    }
}
