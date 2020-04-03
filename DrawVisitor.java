
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class DrawVisitor implements Visitor {
    private final static int DOI = 2, TREI = 3, PATRU = 4, SASE = 6, ZECE = 10;
    /* Deseneaza linia */
    public void visit(final Line line) {
        Color culoare = new Color(line.getRGB().getRed(), line.getRGB().getGreen(),
                line.getRGB().getBlue(), line.getRGB().getAlpha());
        /* Folosesc algoritmul lui Bresenham */
        int x = line.xStart(), y = line.yStart(), ok, aux, s1, s2;
        int deltax = Math.abs(line.xFinal() - line.xStart());
        int deltay = Math.abs(line.yFinal() - line.yStart());
        if (line.xStart() < line.xFinal()) {
            s1 = 1;
        } else {
            s1 = -1;
        }
        if (line.yStart() < line.yFinal()) {
            s2 = 1;
        } else {
            s2 = -1;
        }
        if (deltay > deltax) {
            aux = deltax;
            deltax = deltay;
            deltay = aux;
            ok = 1;
        } else {
            ok = 0;
        }
        int error = 2 * deltay - deltax;
        for (int i = 0; i <= deltax; i++) {
            if (x <= line.getBg().getWidth() - 1 && x >= 0
                    && y <= line.getBg().getHeight() - 1 && y >= 0) {
                line.getBg().setRGB(x, y, culoare.getRGB());
            }
            while (error > 0) {
                if (ok == 1) {
                    x = x + s1;
                } else {
                    y = y + s2;
                }
                error = error - 2 * deltax;
            }
            if (ok == 1) {
                y = y + s2;
            } else {
                x = x + s1;
            }
           error = error + 2 * deltay;
        }
    }
    /* Deseneaza patratul */
    public void visit(final Square square) {
        Color culContS = new Color(square.getRGBContur().getRed(),
                square.getRGBContur().getGreen(), square.getRGBContur().getBlue(),
                square.getRGBContur().getAlpha());
        Color culFillS = new Color(square.getRGBFill().getRed(),
                square.getRGBFill().getGreen(), square.getRGBFill().getBlue(),
                square.getRGBFill().getAlpha());
        int i = square.yStart();
        while (i <= square.yStart() + square.getLatura() - 1 && i >= 0
                && i <= square.getBg().getHeight()) {
               int j = square.xStart();
               while (j <= square.xStart() + square.getLatura() - 1 && j >= 0
                       && j <= square.getBg().getWidth()) {
                   if (i == square.yStart() || j == square.xStart()
                           || i == square.yStart() + square.getLatura() - 1
                           || j == square.xStart() + square.getLatura() - 1) {
                              square.getBg().setRGB(j, i, culContS.getRGB());
                   } else {
                       square.getBg().setRGB(j, i, culFillS.getRGB());
                     }
                   j++;
                   if (j == square.getBg().getWidth()) {
                       break;
                   }
                }
                i++;
                if (i == square.getBg().getHeight()) {
                    break;
                }
               }
    }
    /* Deseneaza dreptunghiul */
    public void visit(final Rectangle rectangle) {
        Color culContR = new Color(rectangle.getRGBContur().getRed(),
                rectangle.getRGBContur().getGreen(), rectangle.getRGBContur().getBlue(),
                rectangle.getRGBContur().getAlpha());
        Color culFillR = new Color(rectangle.getRGBFill().getRed(),
                rectangle.getRGBFill().getGreen(), rectangle.getRGBFill().getBlue(),
                rectangle.getRGBFill().getAlpha());
        int i = rectangle.yStart();
        while (i <= rectangle.yStart() + rectangle.getInaltime() - 1 && i >= 0
                && i <= rectangle.getBg().getHeight()) {
               int j = rectangle.xStart();
               while (j <= rectangle.xStart() + rectangle.getLungime() - 1 && j >= 0
                       && j <= rectangle.getBg().getWidth()) {
                   if (i == rectangle.yStart() || j == rectangle.xStart()
                           || i == rectangle.yStart() + rectangle.getInaltime() - 1
                           || j == rectangle.xStart() + rectangle.getLungime() - 1) {
                       rectangle.getBg().setRGB(j, i, culContR.getRGB());
                   } else {
                       rectangle.getBg().setRGB(j, i, culFillR.getRGB());
                     }
                   j++;
                   if (j == rectangle.getBg().getWidth()) {
                       break;
                   }
                }
                i++;
                if (i == rectangle.getBg().getHeight()) {
                    break;
                }
               }
    }
    /* Deseneaza cercul */
    public void visit(final Circle circle) {
        Color culContC = new Color(circle.getRGBContur().getRed(),
                circle.getRGBContur().getGreen(), circle.getRGBContur().getBlue(),
                circle.getRGBContur().getAlpha());
        Color culFillC = new Color(circle.getRGBFill().getRed(),
                circle.getRGBFill().getGreen(), circle.getRGBFill().getBlue(),
                circle.getRGBFill().getAlpha());
        int d, x = circle.xStart(), y = circle.yStart(), r = circle.getRaza(),
                p = 0, q = circle.getRaza();
        d = TREI - DOI * r;
         while (p < q) {
            if (x + p <= circle.getBg().getWidth() - 1 && x + p >= 0
                    && y + q <= circle.getBg().getHeight() - 1 && y + q >= 0) {
                circle.getBg().setRGB(x + p, y + q, culContC.getRGB());
            }
            if (x - p <= circle.getBg().getWidth() - 1 && x - p >= 0
                    && y + q <= circle.getBg().getHeight() - 1 && y + q >= 0) {
                circle.getBg().setRGB(x - p, y + q, culContC.getRGB());
            }
            if (x + p <= circle.getBg().getWidth() - 1 && x + p >= 0
                    && y - q <= circle.getBg().getHeight() - 1 && y - q >= 0) {
                circle.getBg().setRGB(x + p, y - q, culContC.getRGB());
            }
            if (x - p <= circle.getBg().getWidth() - 1 && x - p >= 0
                    && y - q <= circle.getBg().getHeight() - 1 && y - q >= 0) {
                circle.getBg().setRGB(x - p, y - q, culContC.getRGB());
            }
            if (x + q <= circle.getBg().getWidth() - 1 && x + q >= 0
                    && y + p <= circle.getBg().getHeight() - 1 && y + p >= 0) {
                circle.getBg().setRGB(x + q, y + p, culContC.getRGB());
            }
            if (x - q <= circle.getBg().getWidth() - 1 && x - q >= 0
                    && y + p <= circle.getBg().getHeight() - 1 && y + p >= 0) {
                circle.getBg().setRGB(x - q, y + p, culContC.getRGB());
            }
            if (x + q <= circle.getBg().getWidth() - 1 && x + q >= 0
                    && y - p <= circle.getBg().getHeight() - 1 && y - p >= 0) {
                circle.getBg().setRGB(x + q, y - p, culContC.getRGB());
            }
            if (x - q <= circle.getBg().getWidth() - 1 && x - q >= 0
                    && y - p <= circle.getBg().getHeight() - 1 && y - p >= 0) {
                circle.getBg().setRGB(x - q, y - p, culContC.getRGB());
            }
            p++;
            if (d < 0) {
                d = d + PATRU * p + SASE;
            } else {
                q--;
                d = d + PATRU * (p - q) + ZECE;
            }
            if (x + p <= circle.getBg().getWidth() - 1 && x + p >= 0
                    && y + q <= circle.getBg().getHeight() - 1 && y + q >= 0) {
                circle.getBg().setRGB(x + p, y + q, culContC.getRGB());
            }
            if (x - p <= circle.getBg().getWidth() - 1 && x - p >= 0
                    && y + q <= circle.getBg().getHeight() - 1 && y + q >= 0) {
                circle.getBg().setRGB(x - p, y + q, culContC.getRGB());
            }
            if (x + p <= circle.getBg().getWidth() - 1 && x + p >= 0
                    && y - q <= circle.getBg().getHeight() - 1 && y - q >= 0) {
                circle.getBg().setRGB(x + p, y - q, culContC.getRGB());
            }
            if (x - p <= circle.getBg().getWidth() - 1 && x - p >= 0
                    && y - q <= circle.getBg().getHeight() - 1 && y - q >= 0) {
                circle.getBg().setRGB(x - p, y - q, culContC.getRGB());
            }
            if (x + q <= circle.getBg().getWidth() - 1 && x + q >= 0
                    && y + p <= circle.getBg().getHeight() - 1 && y + p >= 0) {
                circle.getBg().setRGB(x + q, y + p, culContC.getRGB());
            }
            if (x - q <= circle.getBg().getWidth() - 1 && x - q >= 0
                    && y + p <= circle.getBg().getHeight() - 1 && y + p >= 0) {
                circle.getBg().setRGB(x - q, y + p, culContC.getRGB());
            }
            if (x + q <= circle.getBg().getWidth() - 1 && x + q >= 0
                    && y - p <= circle.getBg().getHeight() - 1 && y - p >= 0) {
                circle.getBg().setRGB(x + q, y - p, culContC.getRGB());
            }
            if (x - q <= circle.getBg().getWidth() - 1 && x - q >= 0
                    && y - p <= circle.getBg().getHeight() - 1 && y - p >= 0) {
                circle.getBg().setRGB(x - q, y - p, culContC.getRGB());
            }
        }
        /* Dupa ce am facut conturul cercului, il colorez: */
        floodFill(circle.getBg(), circle.xStart(), circle.yStart(), culContC, culFillC);
    }
    /* Deseneaza triunghiul */
    public void visit(final Triangle triangle) {
        Color culContT = new Color(triangle.getRGBContur().getRed(),
                triangle.getRGBContur().getGreen(), triangle.getRGBContur().getBlue(),
                triangle.getRGBContur().getAlpha());
        Color culFillT = new Color(triangle.getRGBFill().getRed(),
                triangle.getRGBFill().getGreen(), triangle.getRGBFill().getBlue(),
                triangle.getRGBFill().getAlpha());
        /* Folosesc algoritmul lui Bresenham */
        int ok, aux, s1, s2, xs, ys, xf, yf;
        int deltax;
        int deltay;
        for (int j = 0; j < TREI; j++) {
            xs = triangle.p[j].x;
            ys = triangle.p[j].y;
            if (j < DOI) {
                xf = triangle.p[j + 1].x;
                yf = triangle.p[j + 1].y;
            } else {
                xf = triangle.p[0].x;
                yf = triangle.p[0].y;
            }
            deltax = Math.abs(xf - xs);
            deltay = Math.abs(yf - ys);
            if (xs < xf) {
                    s1 = 1;
            } else {
                    s1 = -1;
            }
            if (ys < yf) {
                s2 = 1;
            } else {
                s2 = -1;
            }
            if (deltay > deltax) {
                aux = deltax;
                deltax = deltay;
                deltay = aux;
                ok = 1;
            } else {
                ok = 0;
            }
            int error = 2 * deltay - deltax;
            for (int i = 0; i <= deltax; i++) {
                if (xs <= triangle.getBg().getWidth() - 1 && xs >= 0
                        && ys <= triangle.getBg().getHeight() - 1 && ys >= 0) {
                    triangle.getBg().setRGB(xs, ys, culContT.getRGB());
                }
                while (error > 0) {
                    if (ok == 1) {
                        xs = xs + s1;
                    } else {
                        ys = ys + s2;
                    }
                    error = error - 2 * deltax;
                }
                if (ok == 1) {
                    ys = ys + s2;
                } else {
                    xs = xs + s1;
                }
                error = error + 2 * deltay;
            }
        }
        /* Dupa ce am facut conturul, il colorez: */
        int middlex, middley;
        middlex = (triangle.p[0].x + triangle.p[1].x + triangle.p[2].x) / TREI;
        middley = (triangle.p[0].y + triangle.p[1].y + triangle.p[2].y) / TREI;
        floodFill(triangle.getBg(), middlex, middley, culContT, culFillT);
    }
    /* Deseneaza rombul */
    public void visit(final Diamond diamond) {
        Color culContD = new Color(diamond.getRGBContur().getRed(),
                diamond.getRGBContur().getGreen(), diamond.getRGBContur().getBlue(),
                diamond.getRGBContur().getAlpha());
        Color culFillD = new Color(diamond.getRGBFill().getRed(),
                diamond.getRGBFill().getGreen(), diamond.getRGBFill().getBlue(),
                diamond.getRGBFill().getAlpha());
        /* Folosesc algoritmul lui Bresenham */
        int ok, aux, s1, s2, xs, ys, xf, yf, xc = diamond.getx(), yc = diamond.gety();
        int deltax, deltay, oriz = diamond.getOriz(), vert = diamond.getVert();
        int[] x = new int[PATRU];
        int[] y = new int[PATRU];
        x[0] = xc; y[0] = yc - (int) (vert / DOI);
        x[1] = xc + (int) (oriz / DOI); y[1] = yc;
        x[2] = xc; y[2] = yc + (int) (vert / DOI);
        x[TREI] = xc - (int) (oriz / DOI); y[TREI] = yc;
        Point[] p = new Point[PATRU];
        for (int i = 0; i < PATRU; i++) {
            p[i] = new Point(0, 0);
            p[i].setLocation(x[i], y[i]);
        }
        for (int j = 0; j < PATRU; j++) {
            xs = p[j].x;
            ys = p[j].y;
            if (j < TREI) {
                xf = p[j + 1].x;
                yf = p[j + 1].y;
            } else {
                xs = p[0].x;
                ys = p[0].y;
                xf = p[j].x;
                yf = p[j].y;
            }
            deltax = Math.abs(xf - xs);
            deltay = Math.abs(yf - ys);
            if (xs < xf) {
                    s1 = 1;
            } else {
                    s1 = -1;
            }
            if (ys < yf) {
                s2 = 1;
            } else {
                s2 = -1;
            }
            if (deltay > deltax) {
                aux = deltax;
                deltax = deltay;
                deltay = aux;
                ok = 1;
            } else {
                ok = 0;
            }
            int error = 2 * deltay - deltax;
            for (int i = 0; i <= deltax; i++) {
                if (xs <= diamond.getBg().getWidth() - 1 && xs >= 0
                        && ys <= diamond.getBg().getHeight() - 1 && ys >= 0) {
                    diamond.getBg().setRGB(xs, ys, culContD.getRGB());
                }
                while (error > 0) {
                    if (ok == 1) {
                        xs = xs + s1;
                    } else {
                        ys = ys + s2;
                    }
                    error = error - 2 * deltax;
                }
                if (ok == 1) {
                    ys = ys + s2;
                } else {
                    xs = xs + s1;
                }
                error = error + 2 * deltay;
            }
        }
        /* Dupa ce am facut conturul, il colorez: */
        floodFill(diamond.getBg(), diamond.getx(), diamond.gety(), culContD, culFillD);
    }
    /* Deseneaza poligonul */
    public void visit(final Polygon polygon) {
        Color culContP = new Color(polygon.getRGBContur().getRed(),
                polygon.getRGBContur().getGreen(), polygon.getRGBContur().getBlue(),
                polygon.getRGBContur().getAlpha());
        Color culFillP = new Color(polygon.getRGBFill().getRed(),
                polygon.getRGBFill().getGreen(), polygon.getRGBFill().getBlue(),
                polygon.getRGBFill().getAlpha());
        /* Folosesc algoritmul lui Bresenham */
        int ok, aux, s1, s2, xs, ys, xf, yf;
        int deltax;
        int deltay;
        for (int j = 0; j < polygon.nr(); j++) {
            xs = polygon.p[j].x;
            ys = polygon.p[j].y;
            if (j < polygon.nr() - 1) {
                xf = polygon.p[j + 1].x;
                yf = polygon.p[j + 1].y;
            } else {
                xf = polygon.p[0].x;
                yf = polygon.p[0].y;
            }
            deltax = Math.abs(xf - xs);
            deltay = Math.abs(yf - ys);
            if (xs < xf) {
                    s1 = 1;
            } else {
                    s1 = -1;
            }
            if (ys < yf) {
                s2 = 1;
            } else {
                s2 = -1;
            }
            if (deltay > deltax) {
                aux = deltax;
                deltax = deltay;
                deltay = aux;
                ok = 1;
            } else {
                ok = 0;
            }
            int error = 2 * deltay - deltax;
            for (int i = 0; i <= deltax; i++) {
                if (xs <= polygon.getBg().getWidth() - 1 && xs >= 0
                        && ys <= polygon.getBg().getHeight() - 1 && ys >= 0) {
                    polygon.getBg().setRGB(xs, ys, culContP.getRGB());
                }
                while (error > 0) {
                    if (ok == 1) {
                        xs = xs + s1;
                    } else {
                        ys = ys + s2;
                    }
                    error = error - 2 * deltax;
                }
                if (ok == 1) {
                    ys = ys + s2;
                } else {
                    xs = xs + s1;
                }
                error = error + 2 * deltay;
            }
        }
        /* Dupa ce am facut conturul, il colorez: */
        int middlex = 0, middley = 0;
        for (int i = 0; i < polygon.nr(); i++) {
            middlex += polygon.p[i].x;
            middley += polygon.p[i].y;
        }
        middlex /= polygon.nr();
        middley /= polygon.nr();
        floodFill(polygon.getBg(), middlex, middley, culContP, culFillP);
    }
    /* Algoritm de colorare pornind din centrul formei */
    public static void floodFill(final BufferedImage img, final int x, final int y,
           final Color targetCol, final Color replCol) {
        int srcColor = img.getRGB(x, y);
        boolean[][] changed = new boolean[img.getHeight()][img.getWidth()];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (conditions(img, changed, p.x, p.y, srcColor, replCol.getRGB(),
                    targetCol.getRGB())) {
                queue.add(new Point(p.x, p.y - 1));
                queue.add(new Point(p.x, p.y + 1));
                queue.add(new Point(p.x - 1, p.y));
                queue.add(new Point(p.x + 1, p.y));
            }
        }
    }
    /* Conditii de colorare */
    private static boolean conditions(final BufferedImage image, final boolean[][] changed,
            final int x, final int y, final int srcCol, final int replCol, final int targCol) {
        if (y < 0) {
            return false;
        }
        if (x < 0) {
            return false;
        }
        if (y > image.getHeight() - 1) {
            return false;
        }
        if (x > image.getWidth() - 1) {
            return false;
        }
        if (changed[y][x]) {
            return false;
        }
        if (image.getRGB(x, y) == replCol) {
            return false;
        }
        if (image.getRGB(x, y) == targCol) {
            return false;
        }
        image.setRGB(x, y, replCol);
        changed[y][x] = true;
        return true;
    }
}
