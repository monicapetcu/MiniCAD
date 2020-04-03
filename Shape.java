
import java.awt.image.BufferedImage;
import java.awt.Point;

public interface Shape {
    void setLine(int xstart, int ystart, int xfinal, int yfinal, Culori rgb,
            BufferedImage image);
    void setSquare(int xstart, int ystart, int lat, Culori rgbcontur,
            Culori rgbfill, BufferedImage image);
    void setRectangle(int xstart, int ystart, int h, int lung, Culori rgbcontur,
            Culori rgbfill, BufferedImage image);
    void setCircle(int xstart, int ystart, int r, Culori rgbcontur, Culori rgbfill,
            BufferedImage image);
    void setTriangle(Point[] p, Culori rgbcontur, Culori rgbfill, BufferedImage image);
    void setDiamond(int xmij, int ymij, int diagoriz, int diagvert, Culori rgbcontur,
            Culori rgbfill, BufferedImage image);
    void setPolygon(int nrPct, Point[] points, Culori rgbcontur, Culori rgbfill,
            BufferedImage image);
    String isForm();
    void draw();
}
